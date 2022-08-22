package my.pointmanagement.Config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing // 배치에 필요한 요소들을 자동으로 설정
@Configuration
public class BatchConfig {
}
