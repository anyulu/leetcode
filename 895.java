class Element {
    int num;
    int frequency;
    int index;

    public Element(int num, int frequency, int index) {
        this.num = num;
        this.frequency = frequency;
        this.index = index;
    }
}

class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        return e1.frequency == e2.frequency ? e2.index-e1.index : e2.frequency-e1.frequency;
    }
}

class FreqStack {

    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();
    Queue<Element> queue = new PriorityQueue<>(new ElementComparator());

    public void push(int num) {
        map.put(num, map.getOrDefault(num, 0)+1);
        queue.add(new Element(num, map.get(num), index++));
    }

    public int pop() {
        int num = queue.poll().num;
        if (map.get(num) > 1) map.put(num, map.get(num)-1);
        else map.remove(num);
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */