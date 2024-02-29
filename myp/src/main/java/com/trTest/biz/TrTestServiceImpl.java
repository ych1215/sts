package com.trTest.biz;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.trTest.dao.TrTestMapper;

@Service
public class TrTestServiceImpl {

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	TrTestMapper trTestMapper;

	public int insertUser(Map<String, Object> map) throws Exception {
		return trTestMapper.insertUser(map);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public int insertUser3(Map<String, Object> map) throws Exception {
	    int rtn = 0;
	    rtn = trTestMapper.insertUser3(map);
	    
	    //int a = 1/0; // 여기서 에러나면 부모의 함수에 있는것 다 롤백 된다. 그러므로 부모에 영햘을 받지 않게 하렴 캐치로 잡아야 한다.
	    
	    return rtn;
		
	}

	/**
	 * 일부 끝어서 처리하기.
	 * @param map
	 * @return
	 * @throws Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) // 트랜잭션을 직접 컨트롤하기 때문에 선언해주지 않아도 된다.
	// @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 1000) // 함수 처리 시간이 아니고 쿼리에서 락이 걸리는 시간이다. 
	
	public int insertUser2(Map<String, Object> map) throws Exception {
		TransactionStatus status = null; // TransactionStatus 정의

		try {
			for (int i = 0; i < 50; i++) {
				System.out.println("11111111111" + i);

				if (i % 10 == 0) {
					
					System.out.println("커밋" + i);
					
					// 10 건씩 커밋합니다.
					if (status == null) {
						DefaultTransactionDefinition def = new DefaultTransactionDefinition();
						def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
						status = transactionManager.getTransaction(def);
					} else {
						transactionManager.commit(status); // 10건이 처리된 후 커밋
						status = null; // 트랜잭션 커밋 후 상태를 초기화
					}
				}

				map.put("val", i);
				trTestMapper.insertUser2(map);
				
				if (i  == 30) {
					int a = 1/0; // 부모의 트랜잭션은 롤백 된다. 부모까지 영향을 미치는듯..
				}
			}
			
		} catch (Exception e) {
			if (status != null) {
				transactionManager.rollback(status); // 롤백 필요한 경우
			}
			// throw e; // 예외 다시 던지기 , 부모 롤백 되게 하려면이렇게 예외를 던진다. 부모함수 뿐 아니라 REQUIRES_NEW 한 것도 전부다 롤백 된다.
			            // 부모 에서 흘러 가는것에 영향을 미치 않게 하려면 여끼 처럼 캐치로 잡아햐 한다. 안그럼 예외가 부모 함수로 가서 다 롤백 되어 버린다.
		} finally {
			if (status != null) {
				transactionManager.commit(status); // 나머지 트랜잭션 커밋
			}
		}

		return 1;

	}

}
