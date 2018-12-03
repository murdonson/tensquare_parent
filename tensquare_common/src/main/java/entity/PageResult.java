package entity;

import java.util.List;

/**
 * Created by jzy on 2018/12/3.
 */
public class PageResult<T> {

    private Long total;
    private List<T> row;

    public PageResult(Long total, List<T> row) {
        this.total = total;
        this.row = row;
    }


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRow() {
        return row;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }
}
