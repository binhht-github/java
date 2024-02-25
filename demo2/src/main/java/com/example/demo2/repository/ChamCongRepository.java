package com.example.demo2.repository;

import com.example.demo2.model.ChamCong;
import com.example.demo2.modelDTO.ChamCongStatisticsDTO;
import com.example.demo2.modelDTO.ICCDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;
import java.util.List;

@Repository
public interface ChamCongRepository extends JpaRepository<ChamCong,String> {
    public final static String GET_SO_NGAY_CONG ="CALL getSoNgayCong(?1,date(?2),date(?3))";
    @Query(value = GET_SO_NGAY_CONG,nativeQuery = true)
    Integer tinhNgayCong(String maNhanVien, Date startDate, Date endDate);

//    public final static String GET_CHAMCONG_STATITISTIC ="CALL getListChamCong(?1)";
//    @Query(value = GET_CHAMCONG_STATITISTIC,nativeQuery = true)
    @Query(nativeQuery = true)
    List<ChamCongStatisticsDTO> getChamCongStatistic(Date month);
}
//name = "ChamCongStatisticsDTOChamCongStatisticsDTO",
//        classes = @ConstructorResult(
//        targetClass = ChamCongStatisticsDTO.class,
//        columns = {
//                @ColumnResult(name = "productId", type = Long.class),
//                @ColumnResult(name = "productCode", type = String.class),
//                @ColumnResult(name = "stockAkhir", type = Integer.class)
//        }
//),