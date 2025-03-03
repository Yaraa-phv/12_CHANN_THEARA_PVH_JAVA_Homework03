import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.ArrayList;

public class TableCustom {
    private List<String> headers;
    private List<Object> rowValues;

    public TableCustom() {
        this.headers = new ArrayList<>();
        this.rowValues = new ArrayList<>();
    }

    public void addColumn(String header, Object value) {
        headers.add(header);
        rowValues.add(value);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<Object> getRowValues() {
        return rowValues;
    }
}
