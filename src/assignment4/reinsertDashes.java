package assignment4;

    public class reinsertDashes {
        public String reinsertDashes(String S,int K) {
            String Str1 = S.replaceAll("-","");
            StringBuilder Str2 = new StringBuilder(Str1.toUpperCase());
            if (Str2.length() % K == 0);{
            int a = Str2.length() / K;
            for (int i = 1; i < a; i++) {
                Str2.insert(i * K + i - 1, '-');
            }
        }
        int c = Str2.length() % K;
        int b = (Str2.length() - c) / K;
            for (int j = 0; j < b; j++) {
                Str2.insert(c + 1 + j + j * K, '-');
            }
            String licenseKeyFormatted = Str2.toString();
            return licenseKeyFormatted;
        }

}
