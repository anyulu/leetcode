class Element {
    int index;
    int listIndex;

    public Element(int index, int listIndex) {
        this.index = index;
        this.listIndex = listIndex;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> lists) {
        Queue<Element> queue = new PriorityQueue<>((a,b) ->
            lists.get(a.index).get(a.listIndex)-lists.get(b.index).get(b.listIndex));
        int start = 0, end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                queue.add(new Element(i, 0));
                max = Math.max(max, lists.get(i).get(0));
            }
        }
        while (queue.size() == lists.size()) {
            Element temp = queue.poll();
            if (end-start > max-lists.get(temp.index).get(temp.listIndex)) {
                end = max;
                start = lists.get(temp.index).get(temp.listIndex);
            }
            temp.listIndex++;
            if (temp.listIndex < lists.get(temp.index).size()) {
                queue.add(temp);
                max = Math.max(max,lists.get(temp.index).get(temp.listIndex));
            }
        }
        return new int[] { start, end};
    }
}