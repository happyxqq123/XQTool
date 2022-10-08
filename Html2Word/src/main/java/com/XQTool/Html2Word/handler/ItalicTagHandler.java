package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * <i>斜体</i>
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/8 16:09
 */
public class ItalicTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "i";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        style.setItalic(true);
    }
}
