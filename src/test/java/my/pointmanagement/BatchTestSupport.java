package my.pointmanagement;

import my.pointmanagement.Message.MessageRepository;
import my.pointmanagement.Point.PointRepository;
import my.pointmanagement.Point.reservation.PointReservationRepository;
import my.pointmanagement.Point.wallet.PointWalletRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BatchTestSupport {
    // EnableBatchProcesing 덕분에 가져올수있
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    PointWalletRepository pointWalletRepository;
    @Autowired
    PointRepository pointRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    PointReservationRepository pointReservationRepository;

    private JobExecution launchJob(Job job, JobParameters jobParameters)throws Exception{
        JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
        jobLauncherTestUtils.setJob(job);
        jobLauncherTestUtils.setJobLauncher(jobLauncher);
        jobLauncherTestUtils.setJobRepository(jobRepository);
        return jobLauncherTestUtils.launchJob(jobParameters);
    }
    @AfterEach // 테스트가 끝나면 자동으로 삭제
    protected void deleteAll(){
        pointRepository.deleteAll();
        pointReservationRepository.deleteAll();
        pointWalletRepository.deleteAll();
        messageRepository.deleteAll();;
    }
}
