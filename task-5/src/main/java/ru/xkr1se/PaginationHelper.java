package ru.xkr1se;

/**
 * @author xkr1se
 */
public class PaginationHelper {
    private final int itemsPerPage;
    private final int itemCount;
    private final int pageCount;
    private final boolean unequalItemLastPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;

        this.itemCount = collection.size();
        this.unequalItemLastPage = itemCount % itemsPerPage != 0;
        this.pageCount = itemCount / itemsPerPage + (unequalItemLastPage ? 1 : 0);
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if(pageCount - 1 < pageIndex) {
            return -1;
        }

        if(pageCount - 1 == pageIndex && unequalItemLastPage) {
            return itemCount % itemsPerPage;
        }

        return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemCount == 0) {
            return -1;
        }

        if(itemIndex < 0 || itemIndex > itemCount) {
            return -1;
        }

        if(itemIndex <= itemsPerPage) {
            return 0;
        }

        return itemIndex / itemsPerPage;
    }
}
