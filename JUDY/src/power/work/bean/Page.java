package power.work.bean;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE=4;
    //当前页码
    public Integer pageNo;
    //总页码
    public Integer pageTotal;
    //当前页显示数量
    public Integer pageSize=PAGE_SIZE;
    //总记录数
    public Integer pageTotalCount;
    //当前页数据
    private List<T> items;
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        /*数据有效检查 */
        if (pageNo<1){
            pageNo=1;
        }
        if (pageNo>pageTotal){
            pageNo=pageTotal;
        }
        this.pageNo = pageNo;
    }
    public Integer getPageTotal() {
        return pageTotal;
    }
    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageTotalCount() {
        return pageTotalCount;
    }
    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }
    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageSize=" + pageSize + ", pageTotalCount="
                + pageTotalCount + ", items=" + items + "]";
    }


}
