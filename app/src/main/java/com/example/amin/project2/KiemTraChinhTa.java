package com.example.amin.project2;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by amin on 5/7/2017.
 */

public class KiemTraChinhTa {

//    static char[] nguyen_am = {'u', 'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ứ', 'ừ', 'ữ', 'ử', 'ự', //hai mảng các ký tự nguyên âm
//            'e', 'è', 'é', 'ẽ', 'ẻ', 'ẹ', 'ê', 'ế', 'ề', 'ễ', 'ể', 'ệ',
//            'o', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ơ', 'ớ', 'ờ', 'ỡ', 'ở', 'ợ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ',
//            'a', 'à', 'á', 'ã', 'ả', 'ạ', 'â', 'ấ', 'ầ', 'ậ', 'ẩ', 'ẫ', 'ă', 'ắ', 'ằ', 'ẳ', 'ẵ', 'ặ',
//            'i', 'ì', 'í', 'ĩ', 'ỉ', 'ị', 'y', 'ý', 'ỳ', 'ỹ', 'ỵ', 'ỷ',
//            'U', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ', 'Ư', 'Ứ', 'Ừ', 'Ữ', 'Ử', 'Ự',
//            'E', 'È', 'É', 'Ẽ', 'Ẻ', 'Ẹ', 'Ê', 'Ế', 'Ề', 'Ễ', 'Ể', 'Ệ',
//            'O', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ', 'Ơ', 'Ớ', 'Ờ', 'Ỡ', 'Ở', 'Ợ', 'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ',
//            'A', 'À', 'Á', 'Ã', 'Ả', 'Ạ', 'Â', 'Ấ', 'Ầ', 'Ậ', 'Ẩ', 'Ẫ', 'Ă', 'Ắ', 'Ằ', 'Ẳ', 'Ẵ', 'Ặ',
//            'I', 'Ì', 'Í', 'Ĩ', 'Ỉ', 'Ị', 'Y', 'Ý', 'Ỳ', 'Ỹ', 'Ỷ', 'Ỵ'};
//
//    public boolean kiemTraChinhTa(String s) {
//        if (!check_Special(s)) {
//            if (!luat1(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 1");
//                return false;
//            }
//            if (!luat2(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 2");
//                return false;
//            }
//            if (!luat3(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 3");
//                return false;
//            }
//            if (!luat4(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 4");
//                return false;
//            }
//            if (!luat5(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 5");
//                return false;
//            }
//            if (!luat6(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 6");
//                return false;
//            }
//            if (!luat7(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 7");
//                return false;
//            }
//            if (!luat8(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 8");
//                return false;
//            }
//            if (!luat9(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 9");
//                return false;
//            }
//            if (!luat10(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 10");
//                return false;
//            }
//            if (!luat11(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 11");
//                return false;
//            }
//            if (!luat12(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 12");
//                return false;
//            }
//            if (!luat13(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 13");
//                return false;
//            }
//            if (!luat14(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 14");
//                return false;
//            }
//            if (!luat15(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 15");
//                return false;
//            }
//            if (!luat16(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 16");
//                return false;
//            }
//            if (!luat17(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 17");
//                return false;
//            }
//            if (!luat18(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 18");
//                return false;
//            }
//            if (!luat19(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 19");
//                return false;
//            }
//            if (!luat20(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 20");
//                return false;
//            }
//            if (!luat21(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 21");
//                return false;
//            }
//            if (!luat22(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 22");
//                return false;
//            }
//            if (!luat23(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 23");
//                return false;
//            }
//            if (!luat24(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 24");
//                return false;
//            }
//            if (!luat25(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 25");
//                return false;
//            }
//            if (!luat26(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 26");
//                return false;
//            }
//            if (!luat27(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 27");
//                return false;
//            }
//            if (!luat28(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 28");
//                return false;
//            }
//            if (!luat29(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 29");
//                return false;
//            }
//            if (!luat30(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 30");
//                return false;
//            }
//            if (!luat31(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 31");
//                return false;
//            }
//            if (!luat32(s)) {
//                Log.i("app",s+"_sai luật 32");
//                return false;
//            }
//            if (!luat33(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 33");
//                return false;
//            }
//            if (!luat34(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 34");
//                return false;
//            }
//            if (!luat35(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 35");
//                return false;
//            }
//            if (!luat36(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 36");
//                return false;
//            }
//            if (!luat37(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 37");
//                return false;
//            }
//            if (!luat38(s)) {
//                Log.i("ket qua kiem tra",s+"_sai luật 38");
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean luat1(String x) {
////        String s = "qsddklxvb";
////        for(int j = 1; j < x.length(); j++){
////            if(s.contains(x.charAt(j) + ""))
////                return false;
////        }
//        return true;
//    }
//
//    //luật 2 Một từ tiếng Việt có tối đa 5 phụ âm: nghiêng
//    private boolean luat2(String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++)
//            if (check_Nguyen_Am(s.charAt(i)))
//                count++;
//
//        if (count > 5)
//            return false;
//        return true;
//    }
//
//    //luật 3 Nếu một từ có phụ âm c đứng đầu thì phụ âm sau nó (nếu có) phải là H.
//    private boolean luat3(String s) {
//        if (s.length() >= 2 && s.charAt(0) == 'c' && !check_Nguyen_Am(s.charAt(1)) && s.charAt(1) != 'h')
//            return false;
//        return true;
//    }
//
//    //luật 4  Nếu một từ có 2 phụ âm cạnh nhau thì các phụ âm đó phải là: tr, th, ng , nh, ph, gh, kh, ch
//    private boolean luat4(String s) {
//        if (s.length() >= 2)
//            for (int i = 0; i < s.length() - 1; i++) {
//                if (!check_Nguyen_Am(s.charAt(i)) && !check_Nguyen_Am(s.charAt(i + 1))) {
//                    char c1 = s.charAt(i);
//                    char c2 = s.charAt(i + 1);
//                    if ((c1 == 't' || c1 == 'T') && (c2 == 'r' || c2 == 'R'))
//                        return true;
//                    if ((c1 == 't' || c1 == 'T') && (c2 == 'h' || c2 == 'H'))
//                        return true;
//                    if ((c1 == 'n' || c1 == 'N') && (c2 == 'h' || c2 == 'H'))
//                        return true;
//                    if ((c1 == 'n' || c1 == 'N') && (c2 == 'g' || c2 == 'G'))
//                        return true;
//                    if ((c1 == 'p' || c1 == 'P') && (c2 == 'h' || c2 == 'H'))
//                        return true;
//                    if ((c1 == 'g' || c1 == 'G') && (c2 == 'h' || c2 == 'H'))
//                        return true;
//                    if ((c1 == 'k' || c1 == 'K') && (c2 == 'h' || c2 == 'H'))
//                        return true;
//                    if ((c1 == 'c' || c1 == 'C') && (c2 == 'h' || c2 == 'H'))
//                        return true;
//                    return false;
//                }
//            }
//        return true;
//    }
//
//    //luật 5 Nếu một từ có 3 phụ âm cạnh nhau => đó phải là ngh
//    private boolean luat5(String s) {
//        for (int i = 0; i < s.length() - 2; i++) {
//            if (!check_Nguyen_Am(s.charAt(i)) && !check_Nguyen_Am(s.charAt(i + 1)) && !check_Nguyen_Am(s.charAt(i + 2)))
//                if (!(s.charAt(i) == 'n' || s.charAt(i) == 'N') || s.charAt(i + 1) != 'g' || s.charAt(i + 2) != 'h')
//                    return false;
//        }
//        return true;
//    }
//
//    //luật 6 Trong tiếng Việt, không phải nguyên m nào cũng đứng trước t, c, p, ch được.
//    //Hãy liệt kê các nguyên âm được phép đứng trước chúng.
//    //=> Chỉ có các từ có dấu sắc hoặc dấu nặng được phép.
//    private boolean luat6(String s) {
//        String str1 = "úụứựẹéếệóọộốớợạáắặấậíịyỵýỷÚỤỨỰẸÉẾỆÓỌỘỐỚỢẠÁẮẶẤẬÍỊYÝỶ";
//        String str2 = "tcp";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (str2.contains(s.charAt(i + 1) + "") && check_Nguyen_Am(s.charAt(i))) {
//                if (!str1.contains(s.charAt(i) + ""))
//                    return false;
//            }
//            if (s.charAt(i) == 'c' && s.charAt(i + 1) != 'h' && i >= 1 && !str1.contains(s.charAt(i - 1) + "")) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //luật 7 Trong tiếng Việt có một số phụ âm không được đứng cuối từ: q v b d l k s x r đ
//    private boolean luat7(String s) {
//        String str = "qvbdlksxrđ";
//        if (s.length() >= 1 && str.contains(s.charAt(s.length() - 1) + ""))
//            return false;
//        return true;
//    }
//
//    //luật 8 Có những phụ âm đứng cuối nhưng trước nó không được phép chứa phụ âm khác: n m t p c Có một
//    //số nguyên âm không được đi sau "a" để tạo thành cặp nguyên âm, hãy liệt kê
//    //chúng: tất cả những nguyên âm nào có dấu thì không được đi sau "a", aa, aô, aê, aư, aơ, aă, aâ, ae
//    private boolean luat8(String s) {
//        String str = "nmtcp";
//        int length = s.length();
//        if (length >= 2 && str.contains(s.charAt(length - 1) + "") && !check_Nguyen_Am(s.charAt(length - 2)))
//            return false;
//        return true;
//    }
//
//    //luật 9 Chỉ có một số nguyên âm được phép đứng đằng sau "á" để tạo
//    //thành cặp nguyên âm. Hãy liệt kê: ái, áu, áo, áy
//    private boolean luat9(String s) {
//        String str = "iuoy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'á' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 10 Chỉ có một số nguyên âm được phép đứng đằng sau "ã" để tạo thành cặp nguyên âm. Hãy liệt kê: ãi, ão, ãy
//    private boolean luat10(String s) {
//        String str = "ioy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ã' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 11 Chỉ có một số nguyên âm được phép đứng đằng sau "ạ" để tạo thành cặp nguyên âm. Hãy liệt kê: ại, ạo, ạy
//    private boolean luat11(String s) {
//        String str = "ioy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ạ' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 12 Chỉ có một số nguyên âm được phép đứng đằng sau "ả" để tạo thành cặp nguyên âm. Hãy liệt kê: ải, ảo, ảy.
//    private boolean luat12(String s) {
//        String str = "ioy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ả' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 13 Nếu có "ảu" thì từ này bắt buộc phải nằm trong từ "nhảu"
//    private boolean luat13(String s) {
//        if (s.contains("ảu") && !s.equalsIgnoreCase("nhảu"))
//        return false;
//        return true;
//    }
//
//    //luật 14 Chỉ có một số nguyên âm được phép đứng đằng sau "à" để tạo thành cặp nguyên âm. Hãy liệt kê: ài, àu, ào, ày.
//    private boolean luat14(String s) {
//        String str = "iuoy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'à' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 15 Chỉ có một số nguyên âm được phép đứng đằng sau "â" để tạo thành cặp nguyên âm. Hãy liệt kê: âu, ây
//    private boolean luat15(String s) {
//        String str = "uy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'â' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 16 Chỉ có một số nguyên âm được phép đứng đằng sau "ấ" để tạo thành cặp nguyên âm. Hãy liệt kê: ấu, ấy
//    private boolean luat16(String s) {
//        String str = "uy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ấ' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 17 Chỉ có một số nguyên âm được phép đứng đằng sau "ẩ" để tạo thành cặp nguyên âm. Hãy liệt kê: ẩu, ẩy
//    private boolean luat17(String s) {
//        String str = "uy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ẩ' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 18 Chỉ có một số nguyên âm được phép đứng đằng sau "ẫ" để tạo thành cặp nguyên âm. Hãy liệt kê: ẫu, ẫy
//    private boolean luat18(String s) {
//        String str = "uy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ẫ' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 19 Chỉ có một số nguyên âm được phép đứng đằng sau "ậ" để tạo thành cặp nguyên âm. Hãy liệt kê: ậu, ậy
//    private boolean luat19(String s) {
//        String str = "uy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ậ' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 20 Chỉ có một số nguyên âm được phép đứng đằng sau "ầ" để tạo thành cặp nguyên âm. Hãy liệt kê: ầu, ầy
//    private boolean luat20(String s) {
//        String str = "uy";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'ầ' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 21 KHÔNG nguyên âm được phép đứng đằng sau "ă" để tạo thành cặp nguyên âm
//    //không có nguyên âm nào đằng sau "ằ", "ắ", "ẵ", "ẳ", "ặ"
//    private boolean luat21(String s) {
//        String str = "ăắằẵẳặĂẮẰẴẲẶ";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (str.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 22 Các nguyên âm được phép sau nguyên âm "i": ia, iu, iê, iế, iệ, iể, iễ, iề,
//    private boolean luat22(String s) {
//        String str = "aàáảãạuưứửựữeêếệểễềôỗộổốồóọõòỏóờỡớởỡậấơùúụũủằăắẳặâầấẩẻ";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'i' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 23 Nguyên âm i được phép đi cùng "ữ", nhưng đó phải là từ "giữ"
//    private boolean luat23(String s) {
//        if (s.contains("iữ") && !(s.contains("giữ") || s.contains("Giữ")))
//            return false;
//        if (s.contains("ió") && !(s.contains("gió") || s.contains("Gió")))
//            return false;
//        if (s.contains("iố") && !(s.contains("giố") || s.contains("Giố")))
//            return false;
//        if (s.contains("iọ") && !(s.contains("giọ") || s.contains("Giọ")))
//            return false;
//        if (s.contains("iỏ") && !(s.contains("giỏ") || s.contains("Giỏ")))
//            return false;
//        if (s.contains("iò") && !(s.contains("giò") || s.contains("Gió")))
//            return false;
//        if (s.contains("iá") && !(s.contains("giá") || s.contains("Giá")))
//            return false;
//        if (s.contains("iấ") && !(s.contains("giấ") || s.contains("Giấ")))
//            return false;
//        if (s.contains("iặ") && !(s.contains("giặ") || s.contains("Giặ")))
//            return false;
//        return true;
//    }
//
//    //luật 24 Các nguyên âm được phép sau nguyên âm "ì": ìu, ìa,
//    //Các nguyên âm được phép sau nguyên âm "ỉ": ỉu, mỉa,
//    //Các nguyên âm được phép sau nguyên âm "ị": ịu, ịa,
//    //Các nguyên âm được phép sau nguyên âm "ĩ": ĩu, ĩa,
//    //Các nguyên âm được phép sau nguyên âm "í": íu, ía,
//    private boolean luat24(String s) {
//        String str = "ìỉịĩí";
//        String Str1 = "uaôồốỗộổêểếệễ";
//        for (int i = 0; i < s.length() - 1; i++)
//            if (str.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)) && !Str1.contains(s.charAt(i + 1) + ""))
//                return false;
//        return true;
//    }
//
//    //luật 25 Các nguyên âm được phép sau "e", "é", "è", "ẻ", "ẹ", "ẽ" thì chỉ có: "o"
//    private boolean luat25(String s) {
//        String str = "êếềệ";
//        for (int i = 0; i < s.length() - 1; i++)
//            if (str.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)) && !(s.charAt(i + 1) != 'o'))
//                return false;
//        return true;
//    }
//
//    //luật 26 Các nguyên âm được phép sau "ê", "ế", "ề", "ệ", thì chỉ có: "u"
//    private boolean luat26(String x) {
//        if(x.contains("oo")){
//            if(x.contains("xoong")||x.contains("boong")){
//                return true;
//            }
//            return false;
//        }
//        return true;
//    }
//
//    //luật 27 Nguyên âm "ễu" chỉ được phép đi trong từ "Tễu" và "phễu
//    private boolean luat27(String s) {
//        if (s.contains("ễu") && !(s.equalsIgnoreCase("phễu") || s.equalsIgnoreCase("tễu") || s.contains("iễu")))
//            return false;
//        return true;
//    }
//
//    //luật 28 Nguyên âm "ể" không có nguyên âm khác đi sau
//    private boolean luat28(String s) {
//        for (int i = 0; i < s.length() - 1; i++)
//            if (s.charAt(i) == 'ể' && check_Nguyen_Am(s.charAt(i + 1)))
//                return false;
//        return true;
//    }
//
//    //luật 29 Nguyên âm sau "o" để tạo thành cặp nguyên âm: "oa", "oi", "oe"
//    private boolean luat29(String s) {
//        String str = "aàáảãạiíìỉịĩeẻẹẽéèặắằẳoă";
//        for (int i = 0; i < s.length() - 1; i++)
//            if (s.charAt(i) == 'o' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        return true;
//    }
//
//    //luật 30 Cặp nguyên âm "oo" chỉ có thể thuộc về xoong, boong,
//    private boolean luat30(String s) {
//        if (s.contains("oo") && !(s.equalsIgnoreCase("xoong") || s.equalsIgnoreCase("boong")))
//            return false;
//        return true;
//    }
//
//    //luật 31 Ta có thể tổng quát hóa lên rằng các từ "ó", "ò", "ỏ", "ọ" có các nguyên âm "e", "i", "a" đằng sau được
//    private boolean luat31(String s) {
//        String str1 = "óòỏọ";
//        String str2 = "eia";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (str1.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)) && !str2.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 32 Nguyên âm "ơ", "ớ", "ờ", "ở", "ợ" thì chỉ có đằng sau là nguyên âm "i"
//    private boolean luat32(String s) {
//        String str = "ơớờởợ";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (str.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)) && s.charAt(i + 1) != 'i')
//                return false;
//        }
//        return true;
//    }
//
//    //luật 33 Nguyên âm "ỡ" nếu đi sau nó là "i" thì từ đó phải là "hỡi"
//    private boolean luat33(String s) {
//        if (s.contains("ỡi") && s.equalsIgnoreCase("hỡi"))
//            return false;
//        return true;
//    }
//
//    //luật 34 Nguyên âm "ô", "ố", "ồ", "ổ", "ộ", "ỗ" thì chỉ có đằng sau là nguyên âm "i"
//    private boolean luat34(String s) {
//        String str = "ôốồổộỗ";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (str.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)) && s.charAt(i + 1) != 'i')
//                return false;
//        }
//        return true;
//    }
//
//    //luật 35 Nguyên âm "u" đi đằng sau sẽ là các nguyên âm "i", "a", "y", "ê", "ở", "ế"
//    private boolean luat35(String s) {
//        String str = "iayêởế";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == 'u' && check_Nguyen_Am(s.charAt(i + 1)) && !str.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 36 Nguyên âm "ý", "e" và "ơ", "á", "ả", "ạ" "à" cũng đi sau "u" được nhưng đó phải
//    // là các từ "quý" "que", quơ, "huơ", "quá" quả, quạ, quà
//    private boolean luat36(String s) {
//        if (s.contains("úy") && !s.equalsIgnoreCase("quý"))
//            return false;
//        if (s.contains("ue") && !s.equalsIgnoreCase("que"))
//            return false;
//        if (s.contains("uơ") && !s.equalsIgnoreCase("quơ"))
//            return false;
//        if (s.contains("iọ") && !s.equalsIgnoreCase("giọng"))
//            return false;
//        if (s.contains("uơ") && !s.equalsIgnoreCase("huơ"))
//            return false;
//        if (s.contains("úa") && !s.equalsIgnoreCase("quá"))
//            return false;
//        if (s.contains("uả") && !s.equalsIgnoreCase("quả"))
//            return false;
//        if (s.contains("uạ") && !s.equalsIgnoreCase("quạ"))
//            return false;
//        if (s.contains("uà") && !s.equalsIgnoreCase("quà"))
//            return false;
//        return true;
//    }
//
//    //luật 37 Nguyên âm "ú", "ù", "ủ", "ụ" đi đằng sau sẽ là các nguyên âm "i", "a", "y"
//    private boolean luat37(String s) {
//        String str1 = "úùủụ";
//        String str2 = "iay";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (str1.contains(s.charAt(i) + "") && check_Nguyen_Am(s.charAt(i + 1)) && !str2.contains(s.charAt(i + 1) + ""))
//                return false;
//        }
//        return true;
//    }
//
//    //luật 38 Nguyên âm "ũ" đi sau là y được. Nhưng đi sau là "a" với các trường hợp "đũa", "dũa"
//    private boolean luat38(String s) {
//        if (s.contains("ũa") && !(s.equalsIgnoreCase("đũa") || s.equalsIgnoreCase("đũa")))
//            return false;
//        return true;
//    }
//
//    //hàm kiểm tra kỹ tự là nguyên âm
//    private boolean check_Nguyen_Am(char c) {
//        for (int i = 0; i < nguyen_am.length; i++)
//            if (nguyen_am[i] == c)
//                return true;
//
//        return false;
//    }
//
//    //hàm kiểm tra từ chứa kỹ tự đặc biệt
//    private boolean check_Special(String str) {
//        if (str.contains("<") || str.contains(">")
//                || str.contains("/") || str.contains(".")
//                || str.contains(",") || str.contains(")")
//                || str.contains("(") || str.contains("?")
//                || str.contains("!") || str.contains(";")
//                || str.contains("-") || str.contains("\"")
//                || str.contains("[") || str.contains("]")
//                || str.contains("0") || str.contains("1")
//                || str.contains("2") || str.contains("3")
//                || str.contains("4") || str.contains("5")
//                || str.contains("6") || str.contains("7")
//                || str.contains("8") || str.contains("9")
//                || str.contains(":"))
//            return true;
//        return false;
//    }

    String[] arrAmDau = {"b", "c", "d", "đ", "g", "v", "x", "h", "k", "l", "m", "n", "q", "r",
            "s", "t", "p", "gh", "kh", "ng", "nh", "ph", "th", "ch", "tr", "ngh"};

    String toHopAm = "a á ả ã ạ à ai ái ài ải ại ãi au áu ảu àu ay áy ạy ảy ày ăy ắy ằy ẳy ặy ẵy ây ấy ầy ẩy ậy ẫy" +
            " e ê é è ẻ ẹ ẽ ế ề ể ệ ễ eo éo èo ẻo ẹo ẽo i í ì ị ĩ ỉ ia ía ìa ỉa ĩa ịa iá ià iả iạ iã uyê uyế uyề uyể uyệ" +
            " ă ắ ằ ẳ ặ ẵ â ấ ầ ẩ ậ ẫ o ô ơ ó ò ỏ ọ õ ố ồ ổ ộ ỗ ớ ờ ở ợ ỡ u ư ú ù ủ ụ ũ ứ ừ ử ự ữ iê iế iề iể iệ iễ" +
            " uô uố uồ uổ uộ uỗ ươ ướ ườ ưở ượ ưỡ ua uá uà uả uạ uã uă uắ uằ uẳ uặ uẵ uâ uấ uầ uẩ uậ uẫ" +
            " oa óa òa ỏa ọa õa oă oắ oằ oẳ oặ oẵ oe óe òe ỏe ọe ỏe õe";
    String[] arrToHopAm = toHopAm.split(" ");

    String[] arrAmCuoi = {"c", "m", "n", "p", "t", "ng", "nh", "ch"};

    String[] start;
    String[] end;
    int count;

    public boolean kiemTraChinhTa(String s) {
        String amDau = "";
        String amGiua = "";
        String amCuoi = "";

        //tách âm đầu
        if (s.toLowerCase().startsWith("ngh")) {
            amDau = "ngh";
        }
        else {
            int count = 0;
            for (int i = 17;i <= 24;++i) {
                if (s.toLowerCase().startsWith(arrAmDau[i])) {
                    amDau = arrAmDau[i];
                    count++;
                    break;
                }
            }
            if (count == 0) {
                for (int i = 0; i <= 16;++i) {
                    if (s.toLowerCase().startsWith(arrAmDau[i])) {
                        amDau = arrAmDau[i];
                        break;
                    }
                }
            }
        }

        //tách âm cuối
        count = 0;
        for (int i = 5;i <= 7;i++) {
            if (s.endsWith(arrAmCuoi[i])) {
                amCuoi = arrAmCuoi[i];
                count++;
                break;
            }
        }
        if (count == 0) {
            for (int j = 0;j <= 4;++j) {
                if (s.endsWith(arrAmCuoi[j])) {
                    amCuoi = arrAmCuoi[j];
                    count++;
                    break;
                }
            }
        }

        //tách âm giữa
        int indexDau = s.toLowerCase().indexOf(amDau) + amDau.length();
        int indexCuoi = s.lastIndexOf(amCuoi);
        if (indexDau == -1) {
            if (indexCuoi == -1) {
                amGiua = s;
            }
            else {
                amGiua = s.substring(0,indexCuoi);
            }
        }
        else {
            if (indexCuoi == -1) {
                amGiua = s.substring(indexDau,s.length());
            }
            else {
                amGiua = s.substring(indexDau,indexCuoi);
            }
        }

        if (!check_Special(s)) {
            //tổ hợp âm giữa phải <= 3
            if (amGiua.length() > 3) {
                Log.i("ket qua kiem tra", s + "_tổ hợp âm > 3"+"_"+amDau+"_"+amGiua+"_"+amCuoi);
                return false;
            }

            //kiểm tra âm giữa có trong tập luật không
//            count = 0;
//            for (int i = 0;i < arrToHopAm.length;++i) {
//                if (amGiua.equals(arrToHopAm[i])) {
//                    count++;
//                    break;
//                }
//            }
//            if (count == 0) {
//                Log.i("ket qua kiem tra", s + "_âm giữa không có trong tập luật"+"_"+amDau+"_"+amGiua+"_"+amCuoi);
//                return false;
//            }

            //xử lý kiểm tra
            boolean kiemTra = xuLyKiemTra(s, amDau, amGiua, amCuoi);

            return kiemTra;
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////
//        for (int i = 0;i < arrAmGiua.length;++i) {
//            switch (i) {
//                case 0 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"ngh","gh", "p", "q", "k"};
//                        end = new String[]{"c", "ch", "p", "t"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        for (int j = 0; j < end.length; ++j) {
//                            if (amCuoi.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        return true;
//                    }
//                    break;
//                case 1 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"ngh","gh", "p", "q", "k"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        return true;
//                    }
//                    break;
//                case 2 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"ngh","gh", "p", "q", "k"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        if (!amCuoi.equals("")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                    break;
//                case 3 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"g","k", "ngh", "q", "p"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        if (!amCuoi.equals("")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                    break;
//                case 4 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"g","k", "ngh", "p"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        if (!amCuoi.equals("")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                    break;
//                case 5 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"c","g", "ng", "q", "p"};
//                        end = new String[]{"c", "ch", "p", "t", "nh"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        for (int j = 0; j < end.length; ++j) {
//                            if (amCuoi.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        return true;
//                    }
//                    break;
//                case 6 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"c","g", "ng", "q", "p"};
//                        end = new String[]{"c"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        for (int j = 0; j < end.length; ++j) {
//                            if (amCuoi.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        return true;
//                    }
//                    break;
//                case 7 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"c","d", "đ", "g", "ng", "p", "q"};
//                        end = new String[]{"c"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        if (!amCuoi.equals("")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                    break;
//                case 8 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"c","g", "ng", "p", "q"};
//                        end = new String[]{"c", "ch", "p", "t"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        for (int j = 0; j < end.length; ++j) {
//                            if (amCuoi.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        return true;
//                    }
//                    break;
//                case 9 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"c","g", "ng", "p", "q"};
//                        end = new String[]{"c"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        for (int j = 0; j < end.length; ++j) {
//                            if (amCuoi.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        return true;
//                    }
//                    break;
//                case 10 :
//                    if (arrAmGiua[i].contains(amGiua)) {
//                        start = new String[]{"c","g", "ng", "p", "q"};
//                        end = new String[]{"c"};
//                        //kiểm tra âm đầu
//                        for (int j = 0; j < start.length; ++j) {
//                            if (amDau.equals(start[j])) {
//                                return false;
//                            }
//                        }
//                        //kiểm tra âm cuối
//                        if (!amCuoi.equals("")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                    break;
//            }
//        }

        return true;
    }

    private boolean xuLyKiemTra(String s, String amDau, String amGiua, String amCuoi) {
        if (!luat1(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 1");
            return false;
        }
        if (!luat2(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 2");
            return false;
        }
        if (!luat3(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 3");
            return false;
        }
        if (!luat4(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 4");
            return false;
        }
        if (!luat5(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 5");
            return false;
        }
        if (!luat6(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 6");
            return false;
        }
        if (!luat7(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 7");
            return false;
        }
        if (!luat8(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 8");
            return false;
        }
        if (!luat9(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 9");
            return false;
        }
        if (!luat10(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 10");
            return false;
        }
        if (!luat11(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 11");
            return false;
        }
        if (!luat12(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 12");
            return false;
        }
        if (!luat13(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 13");
            return false;
        }
        if (!luat14(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 14");
            return false;
        }
        if (!luat15(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 15");
            return false;
        }
        if (!luat16(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 16");
            return false;
        }
        if (!luat17(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 17");
            return false;
        }
        if (!luat18(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 18");
            return false;
        }
        if (!luat19(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 19");
            return false;
        }
        if (!luat20(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 20");
            return false;
        }
        if (!luat21(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 21");
            return false;
        }
        if (!luat22(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 22");
            return false;
        }
        if (!luat23(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 23");
            return false;
        }
        if (!luat24(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 24");
            return false;
        }
        if (!luat25(s,amDau,amGiua,amCuoi)) {
            Log.i("ket qua kiem tra",s+"_sai luật 25");
            return false;
        }
//        if (!luat26(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 26");
//            return false;
//        }
//        if (!luat27(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 27");
//            return false;
//        }
//        if (!luat28(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 28");
//            return false;
//        }
//        if (!luat29(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 29");
//            return false;
//        }
//        if (!luat30(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 30");
//            return false;
//        }
//        if (!luat31(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 31");
//            return false;
//        }
//        if (!luat32(s,amDau,amGiua,amCuoi)) {
//            Log.i("app",s+"_sai luật 32");
//            return false;
//        }
//        if (!luat33(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 33");
//            return false;
//        }
//        if (!luat34(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 34");
//            return false;
//        }
//        if (!luat35(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 35");
//            return false;
//        }
//        if (!luat36(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 36");
//            return false;
//        }
//        if (!luat37(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 37");
//            return false;
//        }
//        if (!luat38(s,amDau,amGiua,amCuoi)) {
//            Log.i("ket qua kiem tra",s+"_sai luật 38");
//            return false;
//        }

        return true;
    }

    private boolean luat25(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "oe óe òe ỏe ọe ỏe õe";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c","g", "k", "ng", "p", "q"};
        end = new String[]{"c", "nh", "p"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat24(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "oa óa òa ỏa ọa õa oă oắ oằ oẳ oặ oẵ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c","gh", "k", "ngh", "p", "q"};
        end = new String[]{"ch"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat23(String s, String amDau, String amGiua, String amCuoi) {
        //kiểm tra số lượng nguyên âm
        String nguyenAm = "u ú ù ủ ụ ũ ư ứ ừ ử ự ữ e é è ẻ ẹ ẽ ê ế ề ể ệ ễ o ó ò ỏ ọ õ ô ố ồ ổ ộ ỗ ơ ớ ờ ở ợ ỡ a á à ả ạ ã" +
                " ă ắ ằ ẳ ặ ẵ â ấ ầ ẩ ậ ẫ i í ì ỉ ị ĩ y ý ỳ ỷ ỵ ỹ";
        String[] arrNguyenAm = nguyenAm.split(" ");
        int count = 0;
        for (int i = 0;i < arrNguyenAm.length;++i) {
            for (int j = 0;j < s.length();++j) {
                if ((s.charAt(j)+"").equalsIgnoreCase(arrNguyenAm[i])) {
                    count++;
                }
            }
            if (count > 3) {
                return false;
            }
        }
        return true;
    }

    private boolean luat22(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ua uá uà uả uạ uã uă uắ uằ uẳ uặ uẵ uâ uấ uầ uẩ uậ uẫ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat21(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ươ ướ ườ ưở ượ ưỡ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh", "k", "ngh", "p"};
        end = new String[]{"ch", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat20(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "uô uố uồ uổ uộ uỗ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh", "k", "ngh", "p"};
        end = new String[]{"ch", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat19(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "iê iế iề iể iệ iễ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c", "ng", "p", "q"};
        end = new String[]{"ch", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat18(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ú ù ủ ụ ũ ứ ừ ử ự ữ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p", "q"};
        end = new String[]{"ch", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat17(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "u ư";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p", "q"};
        end = new String[]{"c", "ch", "nh", "p", "t"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat16(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ó ò ỏ ọ õ ố ồ ổ ộ ỗ ớ ờ ở ợ ỡ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p", "q"};
        end = new String[]{"ch", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat15(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "o ô ơ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p", "q"};
        end = new String[]{"c", "ch", "nh", "p", "t"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat14(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ă ắ ằ ẳ ặ ẵ â ấ ầ ẩ ậ ẫ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p", "q"};
        end = new String[]{"ch", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat13(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "uyê uyế uyề uyể uyệ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"b","c", "g", "gh", "ngh", "p"};
        end = new String[]{"c", "ch", "ng", "nh"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat12(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "iá ià iả iạ iã";
        String[] arrAmGiua = strAmGiua.split(" ");
        end = new String[]{"ch"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                if (!amDau.equals("g")) {
                    return false;
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat11(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ia ía ìa ỉa ĩa ịa";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c", "ng", "p", "q"};
        end = new String[]{"c", "ch", "nh", "p", "t"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat10(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "í ì ị ĩ ỉ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"ng", "p", "q"};
        end = new String[]{"c"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat9(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "i";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"ng", "p", "q"};
        end = new String[]{"c", "ch", "p", "t"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat8(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "eo éo èo ẻo ẹo ẽo";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c","d", "đ", "g", "ng", "p", "q"};
        end = new String[]{"c"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat7(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "é è ẻ ẹ ẽ ế ề ể ệ ễ";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c","g", "ng", "q", "p"};
        end = new String[]{"c"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat6(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "e ê";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"c","g", "ng", "q", "p"};
        end = new String[]{"c"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                for (int j = 0; j < end.length; ++j) {
                    if (amCuoi.equals(end[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat5(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ay áy ạy ảy ày ăy ắy ằy ẳy ặy ẵy ây ấy ầy ẩy ậy ẫy";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "p"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                if (!amCuoi.equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean luat4(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "au áu ảu àu";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"gh","k", "ngh", "q", "p"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                if (!amCuoi.equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean luat3(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "ai ái ài ải ại ãi";
        String[] arrAmGiua = strAmGiua.split(" ");
        start = new String[]{"ngh", "gh", "p", "q", "k"};
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
                //kiểm tra âm cuối
                if (!amCuoi.equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean luat2(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "á ả ã ạ à";
        start = new String[]{"ngh", "gh", "p", "q", "k"};
        String[] arrAmGiua = strAmGiua.split(" ");
        for (int i = 0;i < arrAmGiua.length;++i) {
            if (arrAmGiua[i].equals(amGiua)) {
                //kiểm tra âm đầu
                for (int j = 0; j < start.length; ++j) {
                    if (amDau.equals(start[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean luat1(String s, String amDau, String amGiua, String amCuoi) {
        String strAmGiua = "a";
        start = new String[]{"ngh","gh", "p", "q", "k"};
        end = new String[]{"c", "ch", "p", "t"};
        if (strAmGiua.equals(amGiua)) {
            //kiểm tra âm đầu
            for (int j = 0; j < start.length; ++j) {
                if (amDau.equals(start[j])) {
                    return false;
                }
            }
            //kiểm tra âm cuối
            for (int j = 0; j < end.length; ++j) {
                if (amCuoi.equals(end[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    //hàm kiểm tra từ chứa kỹ tự đặc biệt
    private boolean check_Special(String s) {
        String wordSpecical = "< > / . , ( ) ? ! ; - [ ] 0 1 2 3 4 5 6 7 8 9 : ; ";
        String[] word = wordSpecical.split(" ");
        for (int i = 0;i < word.length;++i) {
            if (s.contains(word[i])) {
                return true;
            }
        }
        return false;
    }

}
