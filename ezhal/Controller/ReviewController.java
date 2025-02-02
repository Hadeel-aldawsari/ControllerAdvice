package com.example.ezhal.Controller;


import com.example.ezhal.ApiResponse.ApiResponse;
import com.example.ezhal.Model.RentalItemRequest;
import com.example.ezhal.Model.Review;
import com.example.ezhal.Service.ReviewService;
import com.example.ezhal.Service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {


    private final ReviewService reviewService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(reviewService.getAll());
    }

    @PostMapping("/post-item-review")
    public ResponseEntity postItemReview(@RequestBody @Valid Review review){

        reviewService.postItemReview(review);
        return ResponseEntity.status(200).body(new ApiResponse("Review posted successfully"));
    }


    @PostMapping("/post-Package-review")
    public ResponseEntity posPackageReview(@RequestBody @Valid Review review){

        reviewService.posPackageReview(review);
        return ResponseEntity.status(200).body(new ApiResponse("Review posted successfully"));
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        reviewService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("review deleted successfully"));
    }

    @GetMapping("/top-rated-item")
    public ResponseEntity findToRatedItem(){
        return ResponseEntity.status(200).body(reviewService.findTopRatedItem());
    }

    @GetMapping("/top-rated-Package")
    public ResponseEntity findTopRatedPackage(){
        return ResponseEntity.status(200).body(reviewService.findTopRatedPackage());
    }
}
