package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class ItalicHtmlText extends HtmlText {
    public ItalicHtmlText(String text) {
        super("<i>"+text+"</i>");
    }
}
