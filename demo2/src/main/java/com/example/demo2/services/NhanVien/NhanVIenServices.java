package com.example.demo2.services.NhanVien;

import com.example.demo2.model.Account;
import com.example.demo2.model.NhanVien;
import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.repository.NhanVienRepository;
import com.example.demo2.services.Account.IAccountServices;
import com.example.demo2.until.ModelMapperUntils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NhanVIenServices implements INhanVienServices{
    @Autowired
    ModelMapperUntils mapper;

    @Autowired
    IAccountServices accountServices;

    @Autowired
    NhanVienRepository repository;

    @Override
    public List<NhanVienDTO> findAll() {
        return mapper.mapList(repository.findAll(),NhanVienDTO.class);
    }

    @Override
    public List<NhanVienDTO> finds() {
        return null;
    }

    @Override
    public NhanVienDTO findById(String maNhanVien) {
        if (repository.existsById(maNhanVien)){
//            NhanVien nv = repository.findById(maNhanVien).get();
//            NhanVienDTO nvDTO = new NhanVienDTO(
//                    nv.getMaNhanVien(),
//                    nv.getHoTen(),
//                    nv.getCccd(),
//                    nv.getEmail(),
//                    nv.getGioiTinh(),
//                    nv.getAnh(),
//                    nv.getSdt(),
//                    nv.getDiaChi(),
//                    nv.getPhongBan().getMaPhongBan(),
//                    nv.getNgaySinh(),
//                    nv.getCv(),
//                    nv.getLuongCoBan(),
//                    nv.getHeSoLuong(),
//                    nv.getDeleted(),
//                    new Date(),
//                    nv.getCreator()
//            );
//            return nvDTO;
            return mapper.mapItem(repository.findById(maNhanVien).get(),NhanVienDTO.class);
        }

        return null;
    }

    @Override
    public NhanVienDTO create(NhanVien nhanVien) {
        nhanVien.setMaNhanVien(createMaNhanVien(nhanVien));
        nhanVien.setCreateDate(new Date());
        nhanVien.setLuongCoBan(nhanVien.getChucVu().getMucluongCoBan());
        System.out.println("luong co ban "+nhanVien.getChucVu());
        System.out.println("Nhan Vien Services "+nhanVien);
        if(!repository.existsById(nhanVien.getMaNhanVien())){
//            NhanVien nv = repository.save(nhanVien);
//            NhanVienDTO nvDTO = new NhanVienDTO(
//                nv.getMaNhanVien(),
//                nv.getHoTen(),
//                nv.getCccd(),
//                nv.getEmail(),
//                nv.getGioiTinh(),
//                nv.getAnh(),
//                nv.getSdt(),
//                nv.getDiaChi(),
//                nv.getPhongBan().getMaPhongBan(),
//                nv.getNgaySinh(),
//                nv.getCv(),
//                nv.getLuongCoBan(),
//                nv.getHeSoLuong(),
//                nv.getDeleted(),
//                new Date(),
//                nv.getCreator()
//            );
////            NhanVienDTO nvDTO = new NhanVienDTO(
////                    nv.getMaNhanVien(),
////                    nv.getHoTen(),
////                    nv.getCccd(),
////                    nv.getEmail(),
////                    nv.getGioiTinh(),
////                    nv.getAnh(),
////                    nv.getSdt(),
////                    nv.getDiaChi(),
////                    nv.getPhongBan().getMaPhongBan(),
////                    nv.getNgaySinh(),
////                    nv.getCv(),
////                    nv.getLuongCoBan(),
////                    nv.getHeSoLuong(),
////                    nv.getDeleted(),
////                    new Date(),
////                    nv.getCreator()
////            );
//            if (nv != null ){
////                accountServices.create(new AccountDTO(mapper.mapItem(nv,NhanVien.class),createuserName(nv),createPassWord(),"true",new Date()));
//            }
//            return nvDTO;
            NhanVien nv = repository.save((nhanVien));
//            NhanVienDTO nv = mapper.mapItem(repository.save((nhanVien)),NhanVienDTO.class);
            if (nv != null ){
                accountServices.create(
                        new Account(
                            mapper.mapItem(nv,NhanVien.class),
                            createuserName(nv),
                            "false",
                            new Date()
                        )
                );
            }
            nv.setLuongCoBan(nv.getChucVu().getMucluongCoBan());
            nv.setHeSoLuong(nv.getChucVu().getHeSoLuong());
            return mapper.mapItem(nv,NhanVienDTO.class);

        }
        return null;
    }

    @Override
    public NhanVienDTO update(NhanVien nhanVien) {
        return null;
    }

    @Override
    public List<NhanVienDTO> delete(String id) {
        return null;
    }

    @Override
    public Boolean exitById(String maNhanVien) {
        return repository.existsById(maNhanVien);
    }

    private  String createuserName(NhanVien item){
        String str = "Hoàng Thanh Bình";
        String[] words =  item.getHoTen().split(" ");
        System.out.println(words[1]);
        String result = "";
        result+= StringUtils.stripAccents(words[words.length-1].toLowerCase());
        for (int i = 0; i < words.length-1; i++) {
            result += words[i].toLowerCase().charAt(0);
        }

        return  result+="@gmail.com";
    }
    private  String createPassWord(){

        int length = 6;
        String randomString = RandomStringUtils.random(length, true, true);
//        System.out.println(randomString);
        return randomString;
    }
    protected String createMaNhanVien(NhanVien item){
//        int ma = Integer.parseInt(repository.getMaNhanVien(item.getPhongBan().getMaPhongBan()));
        System.out.println("creaete ma");
        int result = repository.getMaNhanVien(item.getPhongBan().getMaPhongBan());
        System.out.println("check ma before "+result);
//        result=repository.getMaNhanVien(item.getPhongBan().getMaPhongBan())+1;
        System.out.println("check ma after "+result);
        if(result >= 1 && result <9){
            result++;
            System.out.println("1");
            return item.getPhongBan().getMaPhongBan()+"000"+result;
        }
        if(result >= 9&& result <99){
            result++;
            System.out.println("2");
            return item.getPhongBan().getMaPhongBan()+"00"+result;
        }
        if(result >= 99 && result <999){
            result++;
            System.out.println("3");
            return item.getPhongBan().getMaPhongBan()+"0"+result;
        }

//        return item.getPhongBan().getMaPhongBan()+ma;
        return  null;
    }
    public String check(){
        return  repository.getMaNhanVien("DEV01")+"";
    }
}


//c1
//        String str = "Hoàng Thanh Bình";
//        String result = str.split(" ")
//                .stream()
//                .map(word -> word.charAt(0))
//                .collect(Collectors.joining());
//
//        System.out.println(result); // H T B
//c2
//        String str = "Hoàng Thanh Bình";
//        String[] words = str.split(" ");
//        System.out.println(words[1]);
//        String result = "";
//
//        for (String word : words) {
//            result += word.charAt(0);
//        }

//        System.out.println(result);
// c3

//        xóa bỏ dấu
//        String str = "Hoàng";
//        String result = StringUtils.stripAccents(str);
//        System.out.println(result+="@gmail.com");


//        import java.security.SecureRandom;
//        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        int length = 6;
//
//        SecureRandom random = new SecureRandom();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(alphabet.length());
//            char randomChar = alphabet.charAt(index);
//            sb.append(randomChar);
//        }
//
//        String randomString = sb.toString();
//        System.out.println(randomString);


// c2
//        import org.apache.commons.lang3.RandomStringUtils;