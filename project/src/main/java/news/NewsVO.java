package news;

import java.sql.Timestamp;

public class NewsVO {
	private int pageRow; //페이지당 개수 
	private int startIdx; //시작 인덱스
	private int reqPage; //사용자가 요청한 페이지
	private int totCount; //총갯수
//----------------------------------------------------
	private int totPage; //총페이지수
	private int pageRange; //하단페이지 범위
	private int startPage; //시작 페이지 1,11,21,31 ...
	private int endPage;   //끝 페이지  10,20,30,40...


	private String stype; //검색타입(전체, 제목, 내용)
	private String sval; //검색어
	
	
	private String orderby; //정렬컬럼
	private String direct; //오름차순/내림차순
	 
	private String filename_org; //사용자가 첨부한 원본파일명   → multipart타입으로 해도 상관은 없지만 db저장은 문자열만 되기 때문에 Strign으로 지정하고 다른곳에서 처리
	private String filename_real; //서버에 저장된 실제파일명
	
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	
	
	private String isDel;
	
	
	
	//////////////////////////////////////////////////////////////////////
	

	public NewsVO() {
		this.pageRow = 10;
		this.reqPage = 1;
		this.pageRange=10;
		this.orderby="regdate";
		this.direct="DESC";
	}
	
	////////////////////////////////////////////////////////////////////////     ↑ 생성자
	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}
	///////////////////////////////////////////////////////////////////////		↑검색어
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}
	
	public int getTotCount() {
		return totCount;
	}
	public void setTotCount(int totCount) {
		this.totCount = totCount;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getPageRow() {
		return pageRow;
	}
	
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	
	public int getReqPage() {
		return reqPage;
	}
	
	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}
	public int getStartIdx() {
		//board.xml에서만 쓰이는 것이기 때문에 serviceimpl까지 가지않고 여기서 계산
		return (getReqPage()-1)*getPageRow();
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}
	
	//////////////////////////////////////////////////////////////////////	↑ 페이징
	
	
	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		if(!"".equals(orderby)) 	//빈값을 들어갈땐 set을 안함. null값일때 오류 발생가능성 있으므로 문장을 앞에 둠
				this.orderby = orderby;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}
	//////////////////////////////////////////////////////////////////////	↑ 검색정렬
	
	public String getFilename_org() {
		return filename_org;
	}

	public void setFilename_org(String filename_org) {
		this.filename_org = filename_org;
	}

	public String getFilename_real() {
		return filename_real;
	}

	public void setFilename_real(String filename_real) {
		this.filename_real = filename_real;
	}
	
	////////////////////////////////////////////////////////////////////↑ 첨부파일
	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	private int readcount;
}

