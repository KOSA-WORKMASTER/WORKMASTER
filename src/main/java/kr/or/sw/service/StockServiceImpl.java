package kr.or.sw.service;

import kr.or.sw.mapper.StockDAO;
import kr.or.sw.mapper.StockDAOImpl;
import kr.or.sw.model.MemberDTO;
import kr.or.sw.model.StockDTO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StockServiceImpl implements StockService {

    private static StockService instance;

    public static synchronized StockService getInstance() {
        if (instance == null) {
            instance = new StockServiceImpl();
        }
        return instance;
    }

    private final StockDAO stockDAO = StockDAOImpl.getInstance();

    @Override
    public void select(HttpServletRequest request, HttpServletResponse response) {
        log.info("select()");
        
        int stockID = Integer.parseInt(request.getParameter("stockID"));
        StockDTO stockDTO = stockDAO.selectStock(stockID);
        request.setAttribute("stockDTO", stockDTO);
        log.info("stockDTO:{}", stockDTO); 
    }

    @Override
    public void selectAll(HttpServletRequest request, HttpServletResponse response) {
        log.info("selectAll()");
        
        List<StockDTO> list = new ArrayList<>(stockDAO.selectAllStocks());

        request.setAttribute("stockList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));	
    }

    @Override
    public boolean insert(HttpServletRequest request, HttpServletResponse response) {
        log.info("insert()");
        return false;
    }

    @Override
    public boolean delete(HttpServletRequest request, HttpServletResponse response) {
        log.info("delete()");
        return false;
    }

    @Override
    public boolean update(HttpServletRequest request, HttpServletResponse response) {
        log.info("update()");
        return false;
    }

	@Override
	public void searchBy(HttpServletRequest request, HttpServletResponse response) {

		log.info("searchBy()");
		
		List<StockDTO> result;

		String keyword = request.getParameter("keyword");
		
		int searchOption = Integer.parseInt(request.getParameter("searchOption"));
//        if (searchOption == 2) keyword = "%" + keyword + "%";
        
        if (searchOption >= 3) keyword = "%" + keyword + "%";
        
        // searchOption이 1이면 id(숫자) 검색이므로 불필요
        // 나머지는 문자열 포함 여부 검색이므로 like 연산을 위해 앞뒤에 % 추가

        result = switch (searchOption) {
            case 1 -> stockDAO.selectStockById(Integer.parseInt(keyword));
            case 2 -> stockDAO.selectStockByProductID(Integer.parseInt(keyword));
            case 3 -> stockDAO.selectStockByName(keyword);
            default -> throw new IllegalStateException("Unexpected value: " + searchOption);
        };
        List<StockDTO> list = new ArrayList<>(result);
        log.info("size: {}", list.size());

        request.setAttribute("stockList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
        request.setAttribute("searchOption", searchOption);
        request.setAttribute("keyword", keyword);

	}
}