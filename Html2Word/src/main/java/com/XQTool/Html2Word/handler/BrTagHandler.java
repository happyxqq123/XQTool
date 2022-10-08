package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * 换行符
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/8 16:25
 */
public class BrTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "br";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        params.getCurrentRun().addBreak();
    }
}
