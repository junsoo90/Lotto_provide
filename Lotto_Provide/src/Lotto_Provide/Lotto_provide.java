package Lotto_Provide;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;

public interface Lotto_provide { // 분석 해서 제공해라
	
	public Lotto_number result(ArrayList lottolist); // 분석한 로또번호 추출 ( 빈도수가 가장 없는 번호 추출 ) 
	
}
