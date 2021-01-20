package Tiki.Interface;

import Constant.SearchCategory;
import Tiki.PromotionPage;
import Tiki.ResultPage;

public interface SearchAutocompleteInterface {

	PromotionPage chooseItemOnPromoSearch(SearchCategory searchCategory);

	PromotionPage chooseItemOnPromoSearchByIndex(int index);

	ResultPage chooseItemOnSuggestionSearch(SearchCategory searchCategory);

	ResultPage chooseItemOnSuggestionSearchByIndex(int index);

	ResultPage chooseItemOnPopularSearch(SearchCategory searchCategory);

	ResultPage chooseItemOnPopularSearchByIndex(int index);

	ResultPage chooseItemOnFeaturedCategory(SearchCategory searchCategory);

	ResultPage chooseItemOnFeaturedCategoryByIndex(int index);
}
