package com.example.bt_giuaky;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class TrangChuFragment extends Fragment {
    ListView lv_dongvat;
    ArrayList<Dong_vat> dong_vatArrayList;
    DongVatAdapter adapter;
    ArrayList<Chitiet_dv> chitiet_dvArrayList;
    private String voocXam = "Voọc xám (danh pháp hai phần: Trachypithecus phayrei) là một loài vượn đuôi dài sống vùng Đông Nam Á cùng Bangladesh, Ấn Độ và Trung Hoa. Loài này được Blyth mô tả năm 1847.\n" +
            "\n" +
            "Tại Việt Nam Vườn Quốc gia Cúc Phương có một đàn voọc xám.\n" +
            "\n" +
            "Danh pháp khoa học của loài này xưa là Presbytis phayrei.\n" +
            "\n" +
            "Voọc xám có bộ lông màu tro xám nâu trên lưng. Phía bụng thì lông trắng. Lông trên đầu và đuôi đậm hơn. Chung quanh mắt và mồm voọc có vòng khoang trắng. Đặc biệt là voọc con lông vàng cam, đến 3 tháng tuổi thì thay màu lông xám.\n" +
            "\n" +
            "Voọc xám sinh sống hoàn toàn trên cây. Thức ăn của chúng chủ yếu là lá. Voọc đực nặng khoảng 7 kg; voọc cái nhẹ hơn, chỉ khoảng 6 kg. Thân voọc dài 44–61 cm với phần đuôi dài hơn cả thân mình. Trung bình đuôi đo khoảng 65–86 cm.\n" +
            "\n" +
            "Voọc xám sinh sống thành đàn vài ba con nhưng có thể lên đến 40 con.";
    private String cuLiLon = "Cu li lớn hay cu li Sunda (danh pháp hai phần: Nycticebus coucang) là một loại cu li thuộc phân họ Cu li. Loại linh trưởng di chuyển chậm này có mắt to lồi, tai nhỏ và gần như bị lông rậm che khuất. Đuôi của chúng chỉ là một mẩu cụt. Đây là loài sống trên cây, kiếm ăn ban ngày. Cu li Sunda sống ở châu Á.\n" +
            "\n" +
            "Có các phân loài được ghi nhận:\n" +
            "\tNycticebus coucang coucang\n" +
            "\tNycticebus coucang menagensis\n" +
            "\tNycticebus coucang javanicus";
    private String gauCho = "Gấu chó (danh pháp hai phần: Helarctos malayanus, từ đồng nghĩa: Ursus malayanus), được tìm thấy chủ yếu trong các rừng mưa nhiệt đới ở khu vực Đông Nam Á.\n" +
            "\n" +
            "Gấu chó có chiều dài khoảng 1,2 m (4 ft), chiều cao khoảng 0,7 m -do đó chúng là loài nhỏ nhất của họ Gấu. Nó có đuôi ngắn, khoảng 3–7 cm (2 inch) và trung bình nặng không quá 65 kg (145 pao). Gấu chó đực nặng hơn một chút so với gấu cái.\n" +
            "Không giống như các loài gấu khác, lông của chúng ngắn và mượt. Điều này có lẽ là do môi trường sống của chúng là những vùng đất thấp nóng ẩm. Màu lông của chúng là đen sẫm hay nâu đen, ngoại trừ phần ngực có màu vàng-da cam nhạt có hình dạng giống như móng ngựa hoặc hình chữ U. Màu lông tương tự có thể tìm thấy xung quanh mõm và mắt.\n" +
            "\n" +
            "Gấu chó có vuốt có dạng lưỡi liềm, tương đối nhẹ về khối lượng. Chúng có bàn chân to với gan bàn chân trần, có lẽ là để hỗ trợ việc leo trèo. Chân chúng hướng vào trong nên bước đi của chúng giống như đi vòng kiềng, nhưng chúng là những con vật leo trèo giỏi.Chúng có tai ngắn và tròn, mõm ngắn.";
    private String soiDo = "Sói lửa hay chó sói lửa, sói đỏ hay còn biết đến với các tên khác như Chó hoang châu Á, Chó hoang Ấn Độ (danh pháp khoa học: Cuon alpinus) là một loài thú ăn thịt thuộc họ Chó (Canidae), thành viên duy nhất của chi Cuon. Chó sói lửa là động vật sống theo bầy đàn đông đúc giống như chó hoang Châu phi và sói xám, khi đi theo bầy đàn thì sói lửa rất hung tợn và có phương pháp săn mồi tàn độc, đồng thời có thể gây ra nổi hiểm nguy cho cả các mãnh thú khác như hổ hay báo và cả gấu.\n" +
            "\n" +
            "Sói lửa có nguồn gốc từ Nam Á. Khu vực phân bố của nó là từ 10° vĩ nam tới 55° vĩ bắc; 70° kinh đông tới 170° kinh đông[cần dẫn nguồn]. Khu vực phân bố lịch sử của nó trải rộng từ Ấn Độ tới Trung Quốc, Việt Nam và kéo dài xuống tới Malaysia và Indonesia, với đảo Java là giới hạn phía nam.\n" +
            "\n" +
            "Sói lửa thích ứng với một loạt các môi trường sống. Thông thường nó sinh sống trong các môi trường rừng cây lá sớm rụng khô và ẩm cũng như rừng nhiệt đới rậm rạp như các rừng mưa nhiệt đới, để có sự ẩn nấp tốt cho việc săn mồi. Nó sống trong các khu vực có thảm thực vật dạng rừng nguyên sinh, thứ sinh, thoái hóa, thường xanh và bán thường xanh, các rừng cây gai khô, cũng như thảm rừng-trảng cây bụi. Tuy nhiên, nó cũng có thể sống trong các rừng rậm núi cao, các bãi cỏ và các thảo nguyên thoáng đãng tại Kashmir và Mãn Châu. Phần thứ hai trong tên gọi khoa học của nó, alpinus, gợi ý rằng sói lửa thường được tìm thấy trong khu vực miền đồi núi.";
    private String chonBay = "Chồn bay Sunda, tại Việt Nam gọi đơn giản là chồn bay (danh pháp hai phần: Galeopterus variegatus), còn biết đến như là chồn bay Malaya, vượn cáo bay Colugo là một loài chồn bay (Cynocephalidae), bộ Dermoptera. Loài này được Audebert mô tả năm 1799. Cho tới gần đây, nó được coi là một trong hai loài chồn bay còn sinh tồn, loài kia là chồn bay Philippine (Cynocephalus volans) chỉ tìm thấy trên các đảo miền nam Philippines. Chồn bay Sunda được tìm thấy khắp trong khu vực Đông Nam Á, tại Indonesia, Thái Lan, Malaysia, Campuchia, Việt Nam và Singapore.";
    private String voi = "Voi là động vật có vú thuộc họ Elephantidae và là động vật trên cạn lớn nhất hiện nay. Ba loài hiện được công nhận: Voi đồng cỏ châu Phi, voi rừng châu Phi và voi châu Á. Voi châu Phi có tai lớn và lưng lõm còn voi châu Á có tai nhỏ và lưng lồi hoặc ngang. Đặc điểm nổi bật của tất cả các loài voi bao gồm cái vòi dài, cặp ngà lớn, vạt tai lớn, bốn chân to và làn da dày nhưng nhạy cảm. Vòi voi được sử dụng để thở, đưa thức ăn nước uống vào miệng và cầm nắm đồ vật. Đôi ngà, tiến hóa từ răng cửa, được voi dùng để tự vệ, di chuyển chướng ngại vật và đào hố. Đôi tai lớn giúp voi duy trì thân nhiệt ổn định và giao tiếp. Chân chúng to như cây cột để đỡ tải trọng lớn.";
    private String thoVan = "Thỏ vằn Trường Sơn (danh pháp hai phần: Nesolagus timminsi) là một loài động vật có vú trong họ Leporidae, bộ Thỏ. Chúng là loài đặc hữu, chỉ có ở vùng dãy Trường Sơn, khu vực biên giới Việt - Lào. Loài này được Averianov, Abramov & Tikhonov mô tả năm 2000. Thỏ vằn Trường Sơn được cho là một trong những loài thú cổ còn sót lại và một trong hai loài thỏ có sọc (loài còn lại là Thỏ vằn Sumatra). Chúng được ước lượng chỉ còn có khoảng 100 - 200 cá thể và đang đứng trước nguy cơ bị tuyệt chủng. Chúng sống ở độ cao từ 50 mét đến 1.300 mét. Một thế hệ kéo dài 3 năm.";
    private String ran = "Rắn hổ mang chúa (danh pháp hai phần: Ophiophagus hannah), hay hổ mang vua hoặc rắn hổ mây là loài rắn độc thuộc họ Elapidae (họ Rắn hổ), phân bố chủ yếu trong các vùng rừng rậm trải dài từ Ấn Độ đến Đông Nam Á. Loài rắn này đang bị đe dọa do mất môi trường sống và được liệt kê là loài sắp nguy cấp trong sách đỏ IUCN từ năm 2010. Hổ mang chúa là loài rắn độc dài nhất thế giới với cá thể dài nhất từng được ghi nhận là 5,85 m.Rắn hổ chúa được đánh giá là loài nguy hiểm và đáng sợ trong phạm vi sinh sống của chúng, mặc dù loài rắn này không chủ động tấn công con người.";
    private String seuDauDo = "Sếu đầu đỏ, hay còn gọi là sếu cổ trụi, là một phân loài của loài sếu sarus. Đây là phân loài chim quý hiếm tại miền nam Việt Nam, nằm trong Sách đỏ Việt Nam và Sách đỏ IUCN thế giới. Chim trưởng thành đầu và trên cổ trụi lông, trừ một đám màu xám ở má. Họng và vòng bao quanh gáy có ít lông đen. Dưới cổ và toàn bộ lông còn lại màu xám ngọc trai. Cánh con, lông bao quanh cánh sơ cấp và lông cánh sơ cấp đen. Mắt vàng cam. Mỏ xám lục nhạt. Chân đỏ thịt. Da trần ở đỉnh đầu và trước mắt lục xám. Da trần ở đầu và cổ màu đỏ. Khác với loài phụ Ấn Độ (G. a. antigone) có kích thước nhỏ hơn và thiếu vòng trắng ở cổ. Lông cánh tam cấp trắng ở loài phụ Ấn Độ và xám ở loài phụ này ở chim non đầu và cổ có phủ lông nhỏ màu vàng xỉn";
    private String huou = "Hươu vàng (danh pháp khoa học: Hyelaphus porcinus) là một loài động vật có vú trong họ Hươu nai, bộ Guốc chẵn. Một con hươu vàng đực trưởng thành có cân nặng xấp xỉ 50 kg, hươu cái bé hơn, khoảng 30 kg. Chúng trông rất vững vàng và khỏe khoắn với thân hình dài và chân tương đối ngắn, một đường sống lưng đi từ vai cho tới mông. Tai của chúng được cắt tròn, những con hươu vàng già hơn thường có khuôn mặt và cổ nhạt màu những con khác trong đàn. Bộ lông của hươu vàng khá dày, thường có màu nâu tối vào mùa đông, trừ phần dưới của cơ thể và chân thì có màu sáng hơn. Vào cuối mùa xuân, lông của chúng đổi sang màu màu đỏ nâu đậm.";
    private String teGiac = "Tê giác Java hay tê giác Sunda, còn được gọi tê giác một sừng (Rhinoceros sondaicus) là một trong năm loài động vật guốc lẻ còn sống sót của họ Tê giác. Chúng cùng thuộc 1 chi với loài tê giác Ấn Độ, và cũng có một bộ da nếp gấp giống như 1 bộ áo giáp, tuy nhiên chúng chỉ dài có 3,1–3,2 m (10–10,5 ft) và cao 1,4–1,7 m (4,6–5,8 ft), nhỏ hơn tê giác Ấn Độ và gần tương đương với kích cỡ loài tê giác đen. Sừng của tê giác Java có độ dài thường dưới 25 cm (10 inch), nhỏ hơn các loài tê giác khác";
    private String ho = "Hổ hay còn gọi là cọp hoặc hùm (và các tên gọi khác như Ông ba mươi, kễnh, khái) là một loài động vật có vú thuộc họ Mèo được xếp vào một trong năm loài mèo lớn thuộc chi Panthera. Hổ là một loài thú ăn thịt, chúng dễ nhận biết nhất bởi các sọc vằn dọc sẫm màu trên bộ lông màu đỏ cam với phần bụng trắng. Hổ là loài thú lớn nhất trong họ nhà Mèo và là động vật lớn thứ ba trong các loài thú ăn thịt (sau gấu Bắc Cực và gấu nâu). Hổ là một trong những loài động vật có biểu tượng lôi cuốn và dễ nhận biết nhất trên thế giới với những sọc vằn vện không lẫn vào đâu được. Chúng nổi bật trong thần thoại và văn hóa dân gian cổ đại, tiếp tục được miêu tả trong các bộ phim và văn học hiện đại, xuất hiện trên nhiều lá cờ, phù hiệu áo giáp và làm linh vật cho các đội tuyển thể thao. Đặc biệt trong văn hóa phương Đông, hổ được mệnh danh là chúa sơn lâm. Do đó, chúng là biểu tượng quốc gia của nhiều nước như Ấn Độ, Bangladesh, Malaysia và Hàn Quốc.\n" +
            "\n" +
            "Hổ đi săn đơn lẻ, thức ăn của chúng chủ yếu là các động vật ăn cỏ cỡ trung bình như hươu, nai, lợn rừng, trâu, v.v. Tuy nhiên chúng cũng có thể bắt các loại mồi cỡ to hay nhỏ hơn nếu hoàn cảnh cho phép. \n" +
            "\n" +
            "Hổ là một trong số nhiều loài động vật ăn thịt nằm ở mắt xích cuối cùng của các chuỗi thức ăn trong hệ sinh thái tự nhiên. Chúng có tuổi thọ trung bình khoảng 20 năm.";
    private String baoGam = "Báo gấm (Neofelis nebulosa) hay báo mây, (tiếng Anh: Clouded Leopard) là một loài mèo cỡ trung bình trong Họ Mèo, toàn thân dài 60 tới 110 cm  và cân nặng khoảng 11 – 20 kg (25 lbs 4oz - 44 lbs). Lông chúng màu nâu hay hung, điểm hoa elip lớn, hình dạng không đều, gờ màu sẫm trông giống như đám mây, vì thế tên khoa học và một số tiếng nước ngoài đều nhắc tới mây. Chúng phân bố từ chân đồi Himalaya qua đất liền Đông Nam Á vào miền nam Trung Quốc. Kể từ năm 2008, chúng được liệt kê là dễ bị tổn thương trong sách đỏ IUCN. Tổng số lượng cá thể trưởng thành nghi ngờ là ít hơn 10.000, với xu hướng đang giảm về số lượng.";
    private String beo = "Báo lửa (danh pháp khoa học: Catopuma temminckii) hay còn gọi là beo vàng châu Á hay Kim miêu (tiếng Anh: Asian Golden Cat) là một loài động vật ăn thịt thuộc họ Mèo có kích thước trung bình (dài 90 cm, cộng với đuôi dài 50 cm) cân nặng 12 đến 16 kg, chủ yếu sống hoang dã. Trong điều kiện giam cầm báo lửa sống tới 20 năm, nhưng tuổi thọ trung bình của chúng trong tự nhiên thì có lẽ ngắn hơn nhiều. Lông của chúng chủ yếu có màu đỏ đậm như lông cáo hay nâu vàng, nhưng cũng có thể có màu đen hay xám. Thông thường, lớp lông của chúng trơn một màu, nhưng phía dưới có thể có đốm, và thỉnh thoảng có những điểm đốm mờ trên toàn bộ phần lông";
    private String cay = "Cầy mực  là loài động vật ăn thịt thuộc họ Cầy (Viverridae). Môi trường sống của chúng là các khu rừng mưa ở Nam Á và Đông Nam Á. Chúng được liệt vào danh sách loài sắp nguy cấp bởi IUCN do xu hướng suy giảm số lượng cá thể ước tính hơn 30% trong ba thập kỷ qua. Cầy mực là loài thú ăn đêm và ngủ trên các cành cây. Chúng ăn trái cây là chính, ngoài ra còn ăn trứng động vật, mầm cây, lá cây và các loại động vật nhỏ như các loài gặm nhấm hoặc chim. Nạn phá rừng đã làm giảm đáng kể số lượng cầy mực. Cầy mực có thể đạt tuổi thọ trên 20 năm, con cầy mực có tuổi thọ kỉ lục là 26 năm";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trang_chu_fragment,container,false);
        lv_dongvat = (ListView) view.findViewById(R.id.lv_dongvat);
        Danhsach();
        adapter = new DongVatAdapter(getContext(), R.layout.dong_dong_vat, dong_vatArrayList);
        lv_dongvat.setAdapter(adapter);
        lv_dongvat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),chitiet.class);
                intent.putExtra("ten",chitiet_dvArrayList.get(i).getTen());
                intent.putExtra("anh",chitiet_dvArrayList.get(i).getAnh());
                intent.putExtra("mota",chitiet_dvArrayList.get(i).getMota());
                intent.putExtra("tinhtrang",chitiet_dvArrayList.get(i).getTinhtrang());
                startActivity(intent);
            }
        });
        return view;
    }

    private void Danhsach() {
        dong_vatArrayList = new ArrayList<>();
        chitiet_dvArrayList = new ArrayList<>();
        dong_vatArrayList.add(new Dong_vat("Voọc xám", "Một loài vượn đuôi dài", R.drawable.voocxam));
        dong_vatArrayList.add(new Dong_vat("Cu li lớn", "Loài sống trên cây, kiếm ăn ban ngày", R.drawable.culilon));
        dong_vatArrayList.add(new Dong_vat("Gấu chó", "Loài nhỏ nhất của họ Gấu", R.drawable.gaucho));
        dong_vatArrayList.add(new Dong_vat("Sói đỏ", "Một loài thú ăn thịt thuộc họ Chó", R.drawable.soilua));
        dong_vatArrayList.add(new Dong_vat("Chồn bay", "Động vật có vú sống trên cây", R.drawable.chonbay));
        dong_vatArrayList.add(new Dong_vat("Voi", "Động vật trên cạn lớn nhất hiện nay", R.drawable.voi));
        dong_vatArrayList.add(new Dong_vat("Thỏ vằn Trường Sơn", "Động vật có vú trong họ Leporidae, bộ Thỏ", R.drawable.thovan));
        dong_vatArrayList.add(new Dong_vat("Rắn hổ mang chúa", "Loài rắn độc thuộc họ Elapidae", R.drawable.homangchua));
        dong_vatArrayList.add(new Dong_vat("Sếu đầu đỏ","Là một phân loài của loài sếu sarus", R.drawable.seudaudo));
        dong_vatArrayList.add(new Dong_vat("Hươu vàng", "Động vật có vú trong họ Hươu nai, bộ Guốc chẵn", R.drawable.huouvang));
        dong_vatArrayList.add(new Dong_vat("Tê giác một sừng", "Là một trong năm loài động vật guốc lẻ còn sống sót của họ Tê giác",R.drawable.tegiac1sung));
        dong_vatArrayList.add(new Dong_vat("Hổ", "Động vật có vú thuộc họ Mèo", R.drawable.ho));
        dong_vatArrayList.add(new Dong_vat("Báo gấm", "Là một loài mèo cỡ trung bình trong Họ Mèo", R.drawable.baogam));
        dong_vatArrayList.add(new Dong_vat("Beo lửa", "Động vật ăn thịt thuộc họ Mèo", R.drawable.baolua));
        dong_vatArrayList.add(new Dong_vat("Cầy mực", "Loài động vật ăn thịt thuộc họ Cầy", R.drawable.chonmuc));
        chitiet_dvArrayList.add(new Chitiet_dv("Voọc xám",R.drawable.voocxam, voocXam,"Nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Cu li lớn", R.drawable.culilon, cuLiLon, "Nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Gấu chó", R.drawable.gaucho, gauCho,"Sắp nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Sói đỏ", R.drawable.soilua, soiDo,"Nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Chồn bay", R.drawable.chonbay, chonBay,"Ít quan tâm"));
        chitiet_dvArrayList.add(new Chitiet_dv("Voi", R.drawable.voi, voi,"Sắp nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Thỏ vằn Trường sơn",R.drawable.thovan,thoVan,"Nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Rắn hổ mang chúa", R.drawable.homangchua,ran,"Sắp nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Sếu đầu đỏ",R.drawable.seudaudo,seuDauDo,"Sắp nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Hươu vàng", R.drawable.huouvang,huou,"Nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Tê giác một sừng", R.drawable.tegiac1sung,teGiac,"Cực kỳ nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Hổ", R.drawable.ho,ho,"Cực kỳ nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Báo gấm",R.drawable.baogam,baoGam,"Sắp nguy cấp"));
        chitiet_dvArrayList.add(new Chitiet_dv("Beo lửa", R.drawable.baolua,beo,"Sắp bị đe dọa"));
        chitiet_dvArrayList.add(new Chitiet_dv("Cầy mực",R.drawable.chonmuc,cay,"Sắp nguy cấp"));
    }
}