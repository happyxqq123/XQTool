package com.XQTool.Html2Word.handler;

import cn.hutool.core.util.StrUtil;
import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.TextRenderPolicy;
import org.jsoup.nodes.TextNode;

/**
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/7/12 16:26
 */
public class CommonTextTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        String text = "";
        if (params.getCurrentNode() instanceof TextNode) {
            text = ((TextNode) params.getCurrentNode()).text();
        } else {
            //TODO
        }

       // System.out.println(text);

        if (StrUtil.isNotBlank(text)) {
            TextRenderPolicy.Helper.renderTextRun(params.createRun(), new TextRenderData(text, style));
        }

    }
}
