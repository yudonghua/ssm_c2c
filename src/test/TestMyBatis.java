package test;

import com.dao.GoodsDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestMyBatis {
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		System.out.println("static");
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}
	{
		System.out.println("normal");
	}

	public static void main(String[] args) {
		testAdd();
	}

	public static void testAdd() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
			System.out.println(goodsDao.getAllGoods(null));
			sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			sqlSession.close();
		}
	}
}
