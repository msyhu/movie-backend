package com.classlion.movie.domain.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String openDate;

    @Column(nullable = false, length = 10000)
    private String explanation;

    @Builder
    public Movie(String name, String openDate, String explanation) {
        this.name = name;
        this.openDate = openDate;
        this.explanation = explanation;
    }

    public void update(String name, String openDate, String explanation) {
        this.name = name;
        this.openDate = openDate;
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", openDate='" + openDate + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
