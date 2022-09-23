import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {
    @Test
    public void testGetUserByEmpId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp userByEmpId = mapper.getUserByEmpId(2);
        System.out.println("userByEmpId = " + userByEmpId);
    }

    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp userByEmpId = mapper.getEmpAndDeptByEmpId(2);
        System.out.println("userByEmpId = " + userByEmpId);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp);
    }

    @Test
    public void testGetDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println("dept = " + dept);
    }
}
