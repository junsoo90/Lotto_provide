package Lotto_parse;

import java.util.ArrayList;

public interface Lotto_json {
	
	public void lotto_info(); // API활용 로또번호 json 형태로 저장 ( 실시간 데이터 )

	public ArrayList lotto_read(); // 로또번호가 저장된 파일 읽기 ( json )

}
