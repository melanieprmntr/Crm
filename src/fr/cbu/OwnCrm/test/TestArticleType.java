package fr.cbu.OwnCrm.test;

import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.service.ArticleTypeService;

public class TestArticleType {

	public static void main(String[] args) {

		ArticleType articleType = ArticleTypeService.getInstance("Forfait");
		System.out.println(articleType);
	}

}
