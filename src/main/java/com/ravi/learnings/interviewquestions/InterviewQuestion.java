package com.ravi.learnings.interviewquestions;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import lombok.val;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

class InterviewQuestion {
    static final String baseUrl = "https://jsonmock.hackerrank.com/api/tvseries?page=%d";
    public static void main(String[] args) {
        String action = bestInGenre("Action");
        System.out.println(action);
    }


    public static String bestInGenre(String genre) {
        // Write your code here
        List<ShowDetails> allShowList = getAllShowList();
        Map<String, String> showbyRatings = allShowList.stream()
                .filter(showDetails -> showDetails.getGenre().contains(genre))
                .sorted(Comparator.comparing(ShowDetails::getImdb_rating).reversed())
                .collect(Collectors.toMap(
                        ShowDetails::getImdb_rating,
                        ShowDetails::getName,
                        (existing, replace) -> existing.compareTo(replace) < 0 ? existing : replace,
                        LinkedHashMap::new
                ));
//        System.out.println(showbyRatings);

        val next = showbyRatings.entrySet().iterator().next().getValue();
        return next;

    }

    private static List<ShowDetails> getAllShowList() {
        final ApiResponse apiResponse = getApiResponse(1);
        int totalPages = apiResponse.getTotal_pages();
        int total = apiResponse.getTotal();
        ArrayList<ShowDetails> showDetails = new ArrayList<>(total);
        showDetails.addAll(apiResponse.getData());

        for (int i = 2; i <= totalPages; i++) {
            ApiResponse apiRes = getApiResponse(i);
            showDetails.addAll(apiRes.getData());
        }
        return showDetails;
    }

    private static ApiResponse getApiResponse(int pageNumber) {
        try {
            URI uri = new URI(String.format(baseUrl, pageNumber));

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if(httpResponse.statusCode() == 200) {
//                Gson gson = new GsonBuilder().setLenient().create();
                return null;
            }
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return ApiResponse.emptyResponse();
    }

    static class ApiResponse {
        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private List<ShowDetails> data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public List<ShowDetails> getData() {
            return data;
        }

        public void setData(List<ShowDetails> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ApiResponse{" +
                    "page=" + page +
                    ", per_page=" + per_page +
                    ", total=" + total +
                    ", total_pages=" + total_pages +
                    ", data=" + data +
                    '}';
        }
        static ApiResponse emptyResponse() {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setData(Collections.emptyList());
            return apiResponse;
        }
    }

    class ShowDetails{
        private String name;
        private String imdb_rating;
        private String genre;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImdb_rating() {
            return imdb_rating;
        }

        public void setImdb_rating(String imdb_rating) {
            this.imdb_rating = imdb_rating;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "ShowDetails{" +
                    "name='" + name + '\'' +
                    ", imdb_rating='" + imdb_rating + '\'' +
                    ", genre='" + genre + '\'' +
                    '}';
        }
    }
}

