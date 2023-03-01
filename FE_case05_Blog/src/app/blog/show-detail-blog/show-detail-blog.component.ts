import {Component} from '@angular/core';
import {Blog} from "../../model/blog";
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {BlogService} from "../../service/BlogService";

@Component({
  selector: 'app-show-detail-blog',
  templateUrl: './show-detail-blog.component.html',
  styleUrls: ['./show-detail-blog.component.css']
})
export class ShowDetailBlogComponent {
  id: any;
  blog: Blog | undefined;
  formEdit !: FormGroup;

  constructor(private route: ActivatedRoute, private blogService: BlogService, private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id != null) {
      this.blogService.findById(+this.id).subscribe((data) => {
        this.blog = data;
        this.formEdit = new FormGroup({
          id_blog: new FormControl(this.blog?.id_blog),
          name_blog: new FormControl(this.blog?.name_blog),
          content: new FormControl(this.blog?.content),
          content_full: new FormControl(this.blog?.content_full),
          img_blog: new FormControl(this.blog?.img_blog),
          like1: new FormControl(this.blog?.like1),
          category: new FormControl(this.blog?.category.name_category),
          comments: new FormControl(this.blog?.comments[0].content_comment)
        })
      })
    }
  }

}
