package com.example.ezhal.Controller;


import com.example.ezhal.ApiResponse.ApiResponse;
import com.example.ezhal.Model.Item;
import com.example.ezhal.Model.Package;
import com.example.ezhal.Service.ItemService;
import com.example.ezhal.Service.PackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/package")
public class PackageController {
    private final PackageService packageService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(packageService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addByUser(@RequestBody @Valid com.example.ezhal.Model.Package p){

        packageService.add(p);
        return ResponseEntity.status(200).body(new ApiResponse("package added successfully"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Package p){

        packageService.update(id,p);

        return ResponseEntity.status(200).body(new ApiResponse("p updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        packageService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse(" deleted successfully"));
    }
}
