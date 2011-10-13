package com.clouway.collections.pagebean;

import java.util.*;

public class PageBean<T> {

    private List<T> list;
    private List<T> subList;
    private int currentPage = 0;
    private int pageSize;
    private int totalPages;
    private int count = 0;

    public PageBean(List<T> list, int pageSize) {
        this.list = list;
        this.pageSize = pageSize;
        this.totalPages = getTotalPages();
    }

    /**
     * Show next elements from the list
     *
     * @return sublist containing next elements from the list
     * @throws NoNextElementsException if there are no more elements to show
     */
    public List<T> next() throws NoNextElementsException {
        if (count == totalPages || count + 1 > totalPages) {
            throw new NoNextElementsException();
        } else if (count < totalPages - 1) {
            subList = list.subList(currentPage * pageSize, currentPage * pageSize + pageSize);
            currentPage++;
            count++;
        } else {
            subList = list.subList(currentPage * pageSize, list.size());
            currentPage++;
            count++;
        }

        return subList;
    }

    /**
     * Show previous elements from the list
     *
     * @return sublist containing the previous elements from the list
     * @throws NoPreviousElementsException if there are no previous elements to show
     */
    public List<T> previous() throws NoPreviousElementsException {
        if (currentPage == 0 || currentPage - 1 == 0) {
            throw new NoPreviousElementsException();
        } else {
            currentPage -= 1;
            count -= 1;
            subList = list.subList(currentPage * pageSize - pageSize, currentPage * pageSize);
        }

        return subList;
    }

    /**
     * Calculates total pages, needed to present the elements of the list
     *
     * @return the number of pages needed to present the list
     */
    private int getTotalPages() {
        if (list.size() % pageSize == 0) {
            totalPages = list.size() / pageSize;
        } else if (list.size() % pageSize != 0) {
            totalPages = (list.size() / pageSize) + 1;
        }
        return totalPages;
    }

    /**
     * Get current page number
     *
     * @return page number
     */
    public int getCurrentPage() {
        int currentPage = this.currentPage;
        return --currentPage;
    }

    /**
     * Checks whether the list has more next elements
     *
     * @return true if there are next elements, else false
     */
    public boolean hasNext() {
        boolean next = true;
        if (currentPage == totalPages) {
            next = false;
        }
        return next;
    }

    /**
     * Checks whether the list has more previous elements
     *
     * @return true if there are previous elements, else false
     */
    public boolean hasPrevious() {
        boolean previous = true;
        if (currentPage == 0 || currentPage - 1 == 0) {
            previous = false;
        }
        return previous;
    }

    /**
     * Show the first page of the list
     *
     * @return sublist containing the first page of the list
     */
    public List<T> firstPage() {
        subList = list.subList(0, pageSize);
        currentPage = 1;
        count = 1;
        return subList;
    }

    /**
     * Show the last page of the list
     *
     * @return sublist containing the last page of the list
     */
    public List<T> lastPage() {
        subList = list.subList((totalPages - 1) * pageSize, list.size());
        currentPage = totalPages;
        count = currentPage;
        return subList;
    }
}
