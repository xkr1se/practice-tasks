package ru.xkr1se;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author xkr1se
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaginationHelper {
    int itemCount;
    int pageCount;
    int itemsPerPage;
    boolean unequalItemLastPage;

    public PaginationHelper(List<?> collection, int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;

        this.itemCount = collection.size();
        this.unequalItemLastPage = itemCount % itemsPerPage != 0;
        this.pageCount = itemCount / itemsPerPage + (unequalItemLastPage ? 1 : 0);
    }

    public int pageItemCount(int pageIndex) {
        if(pageCount - 1 < pageIndex) {
            return -1;
        }

        if(pageCount - 1 == pageIndex && unequalItemLastPage) {
            return itemCount % itemsPerPage;
        }

        return itemsPerPage;
    }

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
