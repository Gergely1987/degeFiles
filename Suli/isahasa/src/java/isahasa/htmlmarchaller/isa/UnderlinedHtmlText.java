package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedHtmlText extends HtmlText {
    public UnderlinedHtmlText(String text) {
        super("<u>"+text+"</u>");
    }
}
