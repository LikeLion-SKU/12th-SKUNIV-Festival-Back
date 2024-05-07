package Skufestivalback.skufestival.lostItem.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class lostItemResponse {

    private String createdDate;
    private String lostItemName;
    private String lostItemImagePath;
    private String lostDate;
    private String lostLocation;
    private boolean lost; // 분실 여부 추가

    // 날짜 포맷터 정의
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public lostItemResponse(LocalDateTime createdDate, String lostItemName, String lostItemImagePath, String lostDate, String lostLocation, boolean lost) {
        this.createdDate = createdDate.atZone(ZoneId.of("Asia/Seoul")).format(formatter);
        this.lostItemName = lostItemName;
        this.lostItemImagePath = lostItemImagePath;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
        this.lost = lost;
    }

    // lostItem 엔티티에서 lostItemResponse 객체를 생성하는 팩토리 메소드
    public static lostItemResponse build(lostItem lostItem) {
        return new lostItemResponse(
                lostItem.getCreatedDate(),
                lostItem.getLostItemName(),
                lostItem.getLostItemImagePath(),
                lostItem.getLostDate(),
                lostItem.getLostLocation(),
                lostItem.getLost()
        );
    }
}
