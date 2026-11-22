package com.algaworks.algashop.billing.infrastructure;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import(TestcontainerPostgreSQLConfig.class)
@Transactional
public abstract class AbstractPersistenceIT {
}
