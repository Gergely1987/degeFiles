package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Bold extends TextDecorator {
  TextSource textSource;

    public Bold(TextSource textSource) {
        this.textSource = textSource;
    }

    @Override
    public String getPlainText() {
        return "<b>"+textSource.getPlainText()+"</b>";
    }
}
