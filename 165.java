class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> ver1 = new ArrayList<Integer>();
        ArrayList<Integer> ver2 = new ArrayList<Integer>();
        Integer temp = 0;
        for (char i: version1.toCharArray()) {
            if (i != '.') {
                temp  = temp*10 + Integer.parseInt(String.valueOf(i));
            } else {
                ver1.add(temp);
                temp = 0;
            }
        }
        ver1.add(temp);
        temp = 0;
        for (char i: version2.toCharArray()) {
            if (i != '.') {
                temp  = temp*10 + Integer.parseInt(String.valueOf(i));
            } else {
                ver2.add(temp);
                temp = 0;
            }
        }
        ver2.add(temp);
        for (int i = 0; i < Math.min(ver1.size(), ver2.size()); i++) {
            if (ver1.get(i) > ver2.get(i)) return 1;
            else if (ver1.get(i) < ver2.get(i)) return -1;
        }
        if (ver1.size() > ver2.size()) {
            for (int i = ver2.size(); i < ver1.size(); i++) {
                if (ver1.get(i) != 0) return 1;
            }
        }
        if (ver1.size() < ver2.size()) {
            for (int i = ver1.size(); i < ver2.size(); i++) {
                if (ver2.get(i) != 0) return -1;
            }
        }
        return 0;
    }
}