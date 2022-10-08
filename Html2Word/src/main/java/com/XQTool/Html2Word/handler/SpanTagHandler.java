package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * 适用一些纯文本的标签
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/7/12 15:02
 */
public class SpanTagHandler extends BaseHtmlTagHandler {


    @Override
    public String getMatchTagName() {
        return "span";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {

    }
}
