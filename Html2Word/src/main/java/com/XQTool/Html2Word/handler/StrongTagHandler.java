package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * <b>加粗</b>
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/8 16:06
 */
public class StrongTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "b|strong";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        style.setBold(true);
    }
}
