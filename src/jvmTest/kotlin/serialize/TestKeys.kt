package serialize

import client.serialize.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import shouldEqual


@RunWith(JUnit4::class)
internal class TestKeys {

    @Test
    fun keys() {
        "query" shouldEqual KeyQuery
        "searchableAttributes" shouldEqual KeySearchableAttributes
        "attributesForFaceting" shouldEqual KeyAttributesForFaceting
        "UnretrievableAttributes" shouldEqual KeyUnretrievableAttributes
        "attributesToRetrieve" shouldEqual KeyAttributesToRetrieve
        "restrictSearchableAttributes" shouldEqual KeyRestrictSearchableAttributes
        "ranking" shouldEqual KeyRanking
        "customRanking" shouldEqual KeyCustomRanking
        "replicas" shouldEqual KeyReplicas
        "filters" shouldEqual KeyFilters
        "facetFilters" shouldEqual KeyFacetFilters
        "optionalFilters" shouldEqual KeyOptionalFilters
        "numericFilters" shouldEqual KeyNumericFilters
        "tagFilters" shouldEqual KeyTagFilters
        "sumOrFiltersScores" shouldEqual KeySumOrFiltersScores
        "facets" shouldEqual KeyFacets
        "maxValuesPerFacet" shouldEqual KeyMaxValuesPerFacet
        "facetingAfterDistinct" shouldEqual KeyFacetingAfterDistinct
        "sortFacetValuesBy" shouldEqual KeySortFacetValuesBy
        "attributesToHighlight" shouldEqual KeyAttributesToHighlight
        "attributesToSnippet" shouldEqual KeyAttributesToSnippet
        "highlightPreTag" shouldEqual KeyHighlightPreTag
        "highlightPostTag" shouldEqual KeyHighlightPostTag
        "snippetEllipsisText" shouldEqual KeySnippetEllipsisText
        "restrictHighlightAndSnippetArrays" shouldEqual KeyRestrictHighlightAndSnippetArrays
        "page" shouldEqual KeyPage
        "hitsPerPage" shouldEqual KeyHitsPerPage
        "offset" shouldEqual KeyOffset
        "length" shouldEqual KeyLength
        "paginationLimitedTo" shouldEqual KeyPaginationLimitedTo
        "minWordSizefor1Typo" shouldEqual KeyMinWordSizefor1Typo
        "minWordSizefor2Typos" shouldEqual KeyMinWordSizefor2Typos
        "typoTolerance" shouldEqual KeyTypoTolerance
        "allowTyposOnNumericTokens" shouldEqual KeyAllowTyposOnNumericTokens
        "disableTypoToleranceOnAttributes" shouldEqual KeyDisableTypoToleranceOnAttributes
        "disableTypoToleranceOnWords" shouldEqual KeyDisableTypoToleranceOnWords
        "separatorsToIndex" shouldEqual KeySeparatorsToIndex
        "aroundLatLng" shouldEqual KeyAroundLatLng
        "aroundLatLngViaIP" shouldEqual KeyAroundLatLngViaIP
        "aroundRadius" shouldEqual KeyAroundRadius
        "aroundPrecision" shouldEqual KeyAroundPrecision
        "minimumAroundRadius" shouldEqual KeyMinimumAroundRadius
        "insideBoundingBox" shouldEqual KeyInsideBoundingBox
        "insidePolygon" shouldEqual KeyInsidePolygon
        "ignorePlurals" shouldEqual KeyIgnorePlurals
        "removeStopWords" shouldEqual KeyRemoveStopWords
        "camelCaseAttributes" shouldEqual KeyCamelCaseAttributes
        "decompoundedAttributes" shouldEqual KeyDecompoundedAttributes
        "keepDiacriticsOnCharacters" shouldEqual KeyKeepDiacriticsOnCharacters
        "queryLanguages" shouldEqual KeyQueryLanguages
        "enableRules" shouldEqual KeyEnableRules
        "ruleContexts" shouldEqual KeyRuleContexts
        "enablePersonalization" shouldEqual KeyEnablePersonalization
        "queryType" shouldEqual KeyQueryType
        "removeWordsIfNoResults" shouldEqual KeyRemoveWordsIfNoResults
        "advancedSyntax" shouldEqual KeyAdvancedSyntax
        "optionalWords" shouldEqual KeyOptionalWords
        "disablePrefixOnAttributes" shouldEqual KeyDisablePrefixOnAttributes
        "disableExactOnAttributes" shouldEqual KeyDisableExactOnAttributes
        "exactOnSingleWordQuery" shouldEqual KeyExactOnSingleWordQuery
        "alternativesAsExact" shouldEqual KeyAlternativesAsExact
        "numericAttributesForFiltering" shouldEqual KeyNumericAttributesForFiltering
        "allowCompressionOfIntegerArray" shouldEqual KeyAllowCompressionOfIntegerArray
        "attributeForDistinct" shouldEqual KeyAttributeForDistinct
        "distinct" shouldEqual KeyDistinct
        "getRankingInfo" shouldEqual KeyGetRankingInfo
        "clickAnalytics" shouldEqual KeyClickAnalytics
        "analytics" shouldEqual KeyAnalytics
        "analyticsTags" shouldEqual KeyAnalyticsTags
        "synonyms" shouldEqual KeySynonyms
        "replaceSynonymsInHighlight" shouldEqual KeyReplaceSynonymsInHighlight
        "minProximity" shouldEqual KeyMinProximity
        "responseFields" shouldEqual KeyResponseFields
        "maxFacetHits" shouldEqual KeyMaxFacetHits
        "percentileComputation" shouldEqual KeyPercentileComputation
        "geo" shouldEqual KeyGeo
        "typo" shouldEqual KeyTypo
        "words" shouldEqual KeyWords
        "proximity" shouldEqual KeyProximity
        "attribute" shouldEqual KeyAttribute
        "exact" shouldEqual KeyExact
        "custom" shouldEqual KeyCustom
        "asc" shouldEqual KeyAsc
        "desc" shouldEqual KeyDesc
        "strict" shouldEqual KeyStrict
        "min" shouldEqual KeyMin
        "singleWordSynonym" shouldEqual KeySingleWordSynonym
        "multiWordsSynonym" shouldEqual KeyMultiWordsSynonym
        "all" shouldEqual KeyAll
        "word" shouldEqual KeyWord
        "none" shouldEqual KeyNone
        "stopIfEnoughMatches" shouldEqual KeyStopIfEnoughMatches
        "prefixLast" shouldEqual KeyPrefixLast
        "prefixAll" shouldEqual KeyPrefixAll
        "prefixNone" shouldEqual KeyPrefixNone
        "lastWords" shouldEqual KeyLastWords
        "firstWords" shouldEqual KeyFirstWords
        "allOptional" shouldEqual KeyAllOptional
        "*" shouldEqual KeyStar
        "automaticRadius" shouldEqual KeyAutomaticRadius
        "exhaustiveFacetsCount" shouldEqual KeyExhaustiveFacetsCount
        "facets_stats" shouldEqual KeyFacetsStats
        "hits" shouldEqual KeyHits
        "indexName" shouldEqual KeyIndex
        "nbHits" shouldEqual KeyNbHits
        "nbPages" shouldEqual KeyNbPages
        "params" shouldEqual KeyParams
        "processingTimeMS" shouldEqual KeyProcessingTimeMS
        "queryAfterRemoval" shouldEqual KeyQueryAfterRemoval
        "userData" shouldEqual KeyUserData
        "count" shouldEqual KeyCount
        "alpha" shouldEqual KeyAlpha
        "equalOnly" shouldEqual KeyEqualOnly
        "facetQuery" shouldEqual KeyFacetQuery
        "strategy" shouldEqual KeyStrategy
        "requests" shouldEqual KeyRequests
        "indexName" shouldEqual KeyIndexName
        "published" shouldEqual KeyPublished
        "notPublished" shouldEqual KeyNotPublished
        "status" shouldEqual KeyStatus

        "af" shouldEqual KeyAfrikaans
        "ar" shouldEqual KeyArabic
        "az" shouldEqual KeyAzeri
        "bg" shouldEqual KeyBulgarian
        "bn" shouldEqual KeyBrunei
        "ca" shouldEqual KeyCatalan
        "cs" shouldEqual KeyCzech
        "cy" shouldEqual KeyWelsh
        "da" shouldEqual KeyDanish
        "de" shouldEqual KeyGerman
        "en" shouldEqual KeyEnglish
        "eo" shouldEqual KeyEsperanto
        "es" shouldEqual KeySpanish
        "et" shouldEqual KeyEstonian
        "eu" shouldEqual KeyBasque
        "fi" shouldEqual KeyFinnish
        "fo" shouldEqual KeyFaroese
        "fr" shouldEqual KeyFrench
        "gl" shouldEqual KeyGalician
        "he" shouldEqual KeyHebrew
        "hi" shouldEqual KeyHindi
        "hu" shouldEqual KeyHungarian
        "hy" shouldEqual KeyArmenian
        "id" shouldEqual KeyIndonesian
        "is" shouldEqual KeyIcelandic
        "it" shouldEqual KeyItalian
        "ja" shouldEqual KeyJapanese
        "ka" shouldEqual KeyGeorgian
        "kk" shouldEqual KeyKazakh
        "ko" shouldEqual KeyKorean
        "ky" shouldEqual KeyKyrgyz
        "lt" shouldEqual KeyLithuanian
        "mi" shouldEqual KeyMaori
        "mn" shouldEqual KeyMongolian
        "mr" shouldEqual KeyMarathi
        "ms" shouldEqual KeyMalay
        "mt" shouldEqual KeyMaltese
        "nb" shouldEqual KeyNorwegian
        "nl" shouldEqual KeyDutch
        "ns" shouldEqual KeyNorthernSotho
        "pl" shouldEqual KeyPolish
        "ps" shouldEqual KeyPashto
        "pt" shouldEqual KeyPortuguese
        "qu" shouldEqual KeyQuechua
        "ro" shouldEqual KeyRomanian
        "ru" shouldEqual KeyRussian
        "sk" shouldEqual KeySlovak
        "sq" shouldEqual KeyAlbanian
        "sv" shouldEqual KeySwedish
        "sw" shouldEqual KeySwahili
        "ta" shouldEqual KeyTamil
        "te" shouldEqual KeyTelugu
        "tl" shouldEqual KeyTagalog
        "tn" shouldEqual KeyTswana
        "tr" shouldEqual KeyTurkish
        "tt" shouldEqual KeyTatar
    }
}