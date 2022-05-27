package com.rade.dentistbookingsystem.componentform;

import com.rade.dentistbookingsystem.error.BranchError;
import com.rade.dentistbookingsystem.model.BranchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchComponent {
    private BranchDTO branchDTO;
    private BranchError branchError;
}
