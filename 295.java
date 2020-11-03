class MedianFinder {
    List<Integer> list = new ArrayList<>();

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 1) return (double) list.get(size/2);
        else return (double) (list.get(size/2) + list.get(size/2-1))/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */