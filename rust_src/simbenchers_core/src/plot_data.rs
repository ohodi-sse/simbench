// use polars::prelude::*;
//
// fn cluster_cover(distance: impl AsRef<Path>) -> DataFrame {
//     let dist_lf = LazyFrame::scan_parquet("dummy", Default::default())?;
//
//     let dist_df = dist_lf.sort(by = "distance").collect();
//     let dist_df = dist_df.filter(pl.col("distance") <= 1.0);
//     let srcs = dist_df["src"].unique().to_list();
//
//     let height = dist_df.height;
//     for i in 0..height {
//         let row = dist_df.row(i, named = True);
//         let src = row["src"];
//         let tgt = row["tgt"];
//
//         // sphere_dict[src].add(tgt)
//         // k_v_pairs = [(k, set) for k, set in sphere_dict.items()]
//         // relevant_sets = [(tgt, sphere_dict[tgt]) for tgt in sphere_dict[src]]
//         // for tk, relevant_set in relevant_sets:
//         //     if (tk != src) & (sphere_dict[src] == relevant_set):
//         //         # print(f"{tk} and {src} are both {set}")
//         //         total_clusters -= 1
//         //
//         // dist_dict[row["distance"]] = total_clusters
//         // pb.inc(1)
//         //      }
//     }
// }
