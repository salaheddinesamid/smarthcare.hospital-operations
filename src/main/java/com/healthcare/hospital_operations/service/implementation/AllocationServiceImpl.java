package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;
import com.healthcare.hospital_operations.service.AllocationService;
import com.healthcare.hospital_operations.service.RoomAllocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    private final List<RoomAllocationService> processors;

    public AllocationServiceImpl(List<RoomAllocationService> processors) {
        this.processors = processors;
    }

    @Override
    public AllocationRequestDetails requestAllocation(RoomAllocationRequestDto requestDto) {
        try{
            RoomAllocationService processor =
                    processors.stream().filter(p-> p.supports(requestDto.getRoomType()))
                            .findFirst().orElseThrow();

            return processor.requestAllocation(requestDto);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
