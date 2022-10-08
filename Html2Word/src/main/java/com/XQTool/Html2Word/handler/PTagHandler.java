package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * p标签
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/9 16:39
 */
public class PTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "p";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        if (params.isEnableBreak()) {
            //params.getCurrentRun().addBreak();
          //  params.getCurrentRun().addCarriageReturn();
            params.setEnableBreak(false);
        }
    }
}
