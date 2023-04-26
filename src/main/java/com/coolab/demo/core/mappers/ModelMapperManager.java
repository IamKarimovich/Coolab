package com.coolab.demo.core.mappers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{


        private ModelMapper modelMapper;

        @Override
        public ModelMapper forResponse() {
            this.modelMapper.getConfiguration()
                    .setAmbiguityIgnored(true)
                    .setMatchingStrategy(MatchingStrategies.LOOSE);

            return this.modelMapper;
        }

        @Override
        public ModelMapper forRequest() {
            this.modelMapper.getConfiguration()
                    .setAmbiguityIgnored(true)
                    .setMatchingStrategy(MatchingStrategies.STANDARD);

            return this.modelMapper;
        }
}
