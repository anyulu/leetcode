class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains(".") && checkIPv4(IP)) return "IPv4";
        if (IP.contains(":") && checkIPv6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean checkIPv4(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return false;
        String[] segments = IP.split("\\.");
        if (segments.length != 4) return false;
        for (String s: segments) {
            if (s.length() == 0 || s.length() > 3) return false;
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && n == 0) return false;
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    n = n*10+c-'0';
                } else {
                    return false;
                }
            }
            if (n > 255) return false;
        }
        return true;
    }

    private boolean checkIPv6(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return false;
        String[] segments = IP.split(":");        System.out.print(segments.length);
        if (segments.length != 8) return false;
        for (String s: segments) {
            if (s.length() > 4 || s.length() == 0) return false;
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((c >= '0' && c <= '9') ||
                    (c >= 'a' && c <= 'f') ||
                    (c >= 'A' && c <= 'F')) continue;
                else return false;
            }
        }
        return true;
    }
}