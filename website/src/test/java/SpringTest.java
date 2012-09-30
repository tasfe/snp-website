import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;

public class SpringTest extends TestCase {
	public void testFileContext() throws Exception {
		String useranme = "aaa";
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory.getFileAppContext().getBean("advanceDAO");
		String sql = "select o from com.snp.site.model.SiteUser o where o.username='" + useranme + "'";
		List ls = adao.find(sql);
		for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
			SiteUser siteUser = (SiteUser) iterator.next();
			System.out.println(siteUser.getUsername());

		}
		System.out.println(adao);
	}
}
