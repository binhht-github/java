package com.example.demo2.model;

public class note {


//    Chi tiết liên kết cho các bảng trong thiết kế cơ sở dữ liệu quản lý nhân sự:
//            1. Bảng Nhân viên:
//
//    Khóa chính: Mã nhân viên
//    Liên kết:
//    Một-nhiều với bảng Hợp đồng lao động: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Hợp đồng lao động.
//            Một-nhiều với bảng Kỷ luật: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Kỷ luật.
//            Một-nhiều với bảng Đánh giá nhân viên: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Đánh giá nhân viên.
//            Một-nhiều với bảng Lương bổng: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Lương bổng.
//            Một-nhiều với bảng Bảo hiểm xã hội: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Bảo hiểm xã hội.
//2. Bảng Phòng ban:
//
//    Khóa chính: Mã phòng ban
//    Liên kết:
//    Một-nhiều với bảng Nhân viên: Mã phòng ban được sử dụng làm khóa ngoại trong bảng Nhân viên.
//3. Bảng Chức vụ:
//
//    Khóa chính: Mã chức vụ
//    Liên kết:
//    Một-nhiều với bảng Nhân viên: Mã chức vụ được sử dụng làm khóa ngoại trong bảng Nhân viên.
//4. Bảng Hợp đồng lao động:
//
//    Khóa chính: Mã hợp đồng
//    Liên kết:
//    Nhiều-một với bảng Nhân viên: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Hợp đồng lao động.
//5. Bảng Kỷ luật:
//
//    Khóa chính: Mã kỷ luật
//    Liên kết:
//    Nhiều-một với bảng Nhân viên: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Kỷ luật.
//6. Bảng Đánh giá nhân viên:
//
//    Khóa chính: Mã đánh giá
//    Liên kết:
//    Nhiều-một với bảng Nhân viên: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Đánh giá nhân viên.
//7. Bảng Lương bổng:
//
//    Khóa chính: Mã lương
//    Liên kết:
//    Nhiều-một với bảng Nhân viên: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Lương bổng.
//8. Bảng Bảo hiểm xã hội:
//
//    Khóa chính: Mã BHXH
//    Liên kết:
//    Nhiều-một với bảng Nhân viên: Mã nhân viên được sử dụng làm khóa ngoại trong bảng Bảo hiểm xã hội.
//            Một-nhiều với bảng Hồ sơ BHXH: Mã BHXH được sử dụng làm khóa chính trong bảng Hồ sơ BHXH.
//            Một-nhiều với bảng Lịch sử đóng BHXH: Mã BHXH được sử dụng làm khóa chính trong bảng Lịch sử đóng BHXH.
}
