import {DateRange} from "./date.range.obj";
import {Locations} from "./location.enum";
/**
 * Created by Andrew on 4/23/2017.
 *
 * Filtered search object payload.
 */
export interface SearchPayload {
  subjects?; // 0 or more subjects in a list []
  dateRange?: DateRange; // range of dates to look between
  locations?: Locations[] // list of locations for where to search for
}
