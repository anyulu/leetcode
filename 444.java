class Solution {
    public boolean sequenceReconstruction(int[] originalSeq, List<List<Integer>> sequences) {
        if (originalSeq.length == 0 || sequences.size() == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < originalSeq.length; i++) {
            map.put(originalSeq[i], 0);
            requireMap.put(originalSeq[i], new ArrayList<Integer>());
        }
        for (List<Integer> sequence: sequences) {
            for (int i = 0; i < sequence.size(); i++) {
                if (!map.containsKey(sequence.get(i))) return false;
                if (i == sequence.size()-1) break;
                if (!map.containsKey(sequence.get(i+1))) return false;
                map.put(sequence.get(i+1), map.get(sequence.get(i+1))+1);
                requireMap.get(sequence.get(i)).add(sequence.get(i+1));
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 0) queue.add(key);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int root = queue.poll();
            if (originalSeq[index++] != root || !queue.isEmpty()) return false;
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        return originalSeq.length == index;
    }
}