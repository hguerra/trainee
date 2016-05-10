package br.com.orbetail.gettrainee.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author heitor
 * @since 05/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class EmpresaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private EmpresaRepository empresaRepository;

    /**
     * @param empresaRepository
     */
    public void setEmpresaRepository(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Test
    public void persistEmpresaTest() {
        System.out.println(empresaRepository);
    }

    @Ignore
    @Test
    public void findEmpresaTest() {
        fail("TODO");
    }
}
