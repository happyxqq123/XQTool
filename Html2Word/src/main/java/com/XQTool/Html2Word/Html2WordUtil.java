package com.XQTool.Html2Word;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.XQTool.Html2Word.handler.BaseHtmlTagHandler;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.AbstractRenderPolicy;
import com.deepoove.poi.render.RenderContext;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Handler;
import java.util.stream.Stream;

/**
 * @ClassName Html2WordUtil
 * @Description TODO
 * @Author admin
 * @Date 2022/10/8 15:43
 * @Version 1.0
 **/
public class Html2WordUtil {

    private static final int MIN_ARRAY_SORT_GRAN = 1 << 13;

    private static final Map<String, BaseHtmlTagHandler> handlerMap = new ConcurrentHashMap<>();

    static {
        Set<Class<?>> handlerClasses = ClassUtil.scanPackageBySuper(ClassUtil.getPackage(BaseHtmlTagHandler.class),BaseHtmlTagHandler.class);
        if(CollUtil.isNotEmpty(handlerClasses)){

            if(handlerClasses.size()< MIN_ARRAY_SORT_GRAN || ForkJoinPool.getCommonPoolParallelism() == 1){
                for (Class clazz: handlerClasses) {
                    BaseHtmlTagHandler handler = (BaseHtmlTagHandler) ReflectUtil.newInstance(clazz);
                    handlerMap.put(handler.getMatchTagName(),handler);
                }
            }else{
                handlerClasses.parallelStream().forEach(clazz ->{
                    BaseHtmlTagHandler handler = (BaseHtmlTagHandler) ReflectUtil.newInstance(clazz);
                    handlerMap.put(handler.getMatchTagName(),handler);
                });
            }
        }
    }

    public static AbstractRenderPolicy createHtmlRenderPolicy(Object extendParams){
        return new AbstractRenderPolicy() {

            @Override
            protected void afterRender(RenderContext context) {
                super.afterRender(context);
            }

            @Override
            public void doRender(RenderContext renderContext) throws Exception {
                Object data = renderContext.getData();
                if(data == null || StringUtils.isBlank(data.toString())){
                    return;
                }
                NiceXWPFDocument doc = renderContext.getTemplate().getXWPFDocument();

                XWPFTemplate xwpfTemplate = renderContext.getTemplate();
                String html = data.toString();
                // 处理html实体符号
                html = html.replaceAll("&gt;", ">")
                        .replaceAll("&lt;", "<")
                        .replaceAll("&nbsp;", " ")
                        .replaceAll("\\n", "")
                        .replaceAll("\\r", "")
                        .replaceAll("&crarr;", "")
                        .replaceAll("&quot;", "\"")
                        .replaceAll("&apos;", "'")
                        .replaceAll("&cent;", "￠")
                        .replaceAll("&pound;", "£")
                        .replaceAll("&yen;", "¥")
                        .replaceAll("&euro;", "€")
                        .replaceAll("&sect;", "§")
                        .replaceAll("&copy;", "©")
                        .replaceAll("&reg;", "®")
                        .replaceAll("&trade;", "™")
                        .replaceAll("&times;", "×")
                        .replaceAll("&divide;", "÷")
                        .replaceAll("&amp;", "&");
                org.jsoup.nodes.Document htmlDoc = Jsoup.parse(html);
                List<Node> nodes = htmlDoc.body().childNodes();

                HandlerParams handlerParams = new HandlerParams();
                handlerParams.setDoc(doc);
                handlerParams.setCurrentParagraph(renderContext.getRun().getParagraph());
                handlerParams.setCurrentRun(renderContext.getRun());
                handlerParams.insertNewParagraph();
                handlerParams.setEnableBreak(false);
                handlerParams.setExtendedParams(extendParams);
                Iterator<Node> itr = nodes.iterator();
                while(itr.hasNext()){
                    handlerParams.setCurrentNode(itr.next());
                    Style style = new Style();
                    style.setFontSize(13);
                    parseHtml2Word(handlerParams,style);
                }
            }
        };
    }

    public static void parseHtml2Word(HandlerParams handlerParams ,Style style){
         Node ele = handlerParams.getCurrentNode();
         BaseHtmlTagHandler handler = getHandler("");
         if(ele instanceof Element){
             handler = getHandler(((Element) ele).tagName());
             handler.handleHtmlElement(handlerParams, style);
         }else{
             handler.handleHtmlElement(handlerParams, style);
         }
         //parse child node
         if(handlerParams.getContinueItr() && ele.childNodes().size() > 0){
             Iterator<Node> itr = ele.childNodes().listIterator();
             while(itr.hasNext()){
                 handlerParams.setCurrentNode(itr.next());
                 parseHtml2Word(handlerParams,copyStyle(style));
             }
         }
    }

    private static Style copyStyle(Style style){
        if(style == null){
            return new Style();
        }
        Style style2 = new Style();
        BeanUtil.copyProperties(style,style2);
        return style2;
    }



    private static BaseHtmlTagHandler getHandler(final String tagName){
        if(tagName == null){
            return null;
        }
        if(handlerMap.size() < MIN_ARRAY_SORT_GRAN || ForkJoinPool.getCommonPoolParallelism() == 1){
            Optional<String> keyOpt= handlerMap.keySet().stream().filter(key->{
                 if(key.equals(tagName)){
                     return true;
                 }
                 return false;
             }).findFirst();

            if(keyOpt.isPresent()){
                handlerMap.get(keyOpt.get());
            }else{
                return null;
            }
        }else{
            //parallel search
            Optional<String> keyOpt = handlerMap.keySet().parallelStream().filter(key->{
                if(key.equals(tagName)){
                    return true;
                }
                return false;
            }).findFirst();

            if(keyOpt.isPresent()){
                handlerMap.get(keyOpt.get());
            }else{
                return null;
            }
        }
        return null;
    }

    public static InputStream getResourceInputStream(String filePath){
        InputStream in = FileUtil.class.getResourceAsStream(filePath);
        if(in != null){
            return in;
        }
        return null;
    }



}
