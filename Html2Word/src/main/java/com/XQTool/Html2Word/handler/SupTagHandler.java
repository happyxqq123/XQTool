package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.TextRenderPolicy;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;

/**
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/7/12 15:21
 */
public class SupTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "sup";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        XWPFRun run = params.createRun();
        Element element = (Element)params.getCurrentNode();
        run.setText(element.text());
        // 设置字体加粗;
        run.setBold(true);
        // 设置字体大小;
/*        run.setFontSize(12);
        run.setFontFamily("Times New Roman", XWPFRun.FontCharRange.ascii);
        run.setFontFamily("宋体", XWPFRun.FontCharRange.eastAsia);
        run.setSubscript(VerticalAlign.SUPERSCRIPT);*/

        TextRenderPolicy.Helper.renderTextRun(run, new TextRenderData(element.text()));
        params.setContinueItr(false);
    }
}
